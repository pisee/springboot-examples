# JPA  
## SQL을 직접 다룰 때 발생하는 문제점
### CRUD의 반복...  

	public class User{  
		private String userId;  
		private String userName;  
	}

	public class UserDao{
		public User find(String userId){...}
		public void save(User user){...}
	} 
	
1. SQL 작성  
1. JDBC 작성  
	1. Connection 객체  
	2. PreparedStatement 객체 - executeQuery  
1. ResultSet to VO 전환  

### SQL 의존적인 개발  
- User 테이블에 전화번호가 추가되었다  

	public class User{  
		private String userId;  
		private String userName;  
		private String phone;  // added
	}  
- CRUD 코드 수정  
	- SQL 수정  
	- 조회 : mapper 에 필드 추가  
	- 수정, 입력 : jdbc preparedstatement 에 phone 파라미터 추가  
<br>
- 데이터베이스가 아닌 자바 컬렉션에 저장되었다면 필드 추가에 따른 코드 수정이 많이 발생하지는 않는다.  

	list.add(user);  // C  
	User user = list.get(xxx);  // R    
	user.setPhone(xxx);  // U  
	
- 연관된 객체의 추가 : Group 이 필요해 졌다. (계층분할) 

	public class User{  
		private String userId;  
		private String userName;  
		private String phone;  
		private Group group;  // added
	}  

	public class UserDao{
		public User find(String userId){...}
		public void save(User user){...}
		public User findWithGroup(String UserId){...}
	} 
- SQL을 직접 다룰 때 발생하는 문제점  
	- 진정한 의미의 계층분할이 어렵다. : DAO 를 열어서 어떤 SQL 이 실행되고 어떤 객체들이 함께 조회되는지 확인해야 한다.   
	- 엔티티를 신뢰할 수 없다.  : SQL 에 작성되지 않는 엔티티는 조회되지 않는다.  
	- SQL에 의존적인 개발을 피하기 어렵다.  : 엔티티와 SQL간의 한 의존관계 때문에 객체 필드추가 같은 경우에도 DAO, SQL을 변경해야 한다. 
	
### JPA 와 문제 해결  
JPA 를 사용하면 객체를 데이터베이스에 저장하고 관리 할때, 개발자가 직접 SQL 을 작성하는 것이 아니라 JPA가 제공하는 API를 사용하면 된다.  
그러면 JPA 가 개발자 대신에 적절한 SQL을 생성해서 데이터 베이스에 전달한다.  

## 패러다임의 불일치  
객체지향언어와 관계형 데이터베이스간의 문제를 개발자가 중간에서 해결해야 한다.  
해결하는데 드는 시간과 코드의 소비가 크다.
### 상속  

	public class Artist{
		private String name;
		private String id;
	}

	public class Singer extends Artist{
		private String albumTItle;
	}

	public class Actor extends Artist{
		private String movieTitle;
	}
- Singer 객체를 저장하려면...  
	- artist, Singer SQL 두개 작성필요  
	- Artist 객체의 필드데이터만 꺼내서 artist 테이블 insert  
	- Singer 객체의 필드데이터만 꺼내서 singer 테이블 insert  
<br>	
- 자바컬렉션에 저장한다면..  

	list.add(singer);
	list.add(Actor);
	Singer singer = list.get(id);
- JPA 에서 상속...  
	- 개발자는 자바 컬렉션에 객체를 저장하듯 JPA에 객체를 저장하면 된다. 

	jpa.save(singer);
	Singer singer = jpa.find(Singer.class, id); 
	

### 연관관계  
객체는 참조를 사용해서 다른 객체와의 연관관계를 가지고 참조에 접근해서 연관된 객체를 조회한다.  
테이블은 외래키를 사용해서 다른 테이블과의 연관관계를 가지고 조인을 사용해서 연관된 테이블을 조회한다.

- 객체지향 모델링

	public class User{  
		private String userId;  
		private String userName;  
		private Group group;  
	}  
	public class Group{
		private String groupId;
		private String groupName;
	}


- 객체를 테이블에 맞춰 모델링하면...

	public class User{  
		private String userId;  
		private String userName; 
		private String groupId;
	}  
	public class Group{
		private String groupId;
		private String groupName;
	}

객체모델은 외래키가 필요없고 참조만 있으면되나, 테이블은 참조가 필요없고 외래키만 있으면 된다.  
결국 개발자가 중간에서 직접 연관관계를 변환해주는 역할을 해야 한다.
<br>
- JPA 연관관계


	user.setGroup(group);
	jpa.persist(user);
	
	User user = jpa.find(User.class, userId);
	Group group = user.getGroup();
	
### 객체그래프 탐색  
객체의 그래프 탐색은 자유롭다.

	member.getOrder().getOrderItem().......
	member.getTeam().getManager()....
테이블에서 member - order sql은 작성되었으나 member - order - orderItem sql은 없다면...  
SQL을 직접 다루면, 실행하는 SQL 에 따라 객체를 어디까지 탐색할 수 있는지 정해진다.  
- JPA 그래프 탐색  
JPA 는 연관된 객체를 사용하는 시점에 적절한 select sql을 실행한다. (지연로딩)  
설정에 따라 연관된 객체를 즉시 함께 조회할지 아니면 사용되는 시점에 지연로딩 조회할지 정할 수 있다.  

### 비교  
동일성비교(==) : 객체의 인스턴스 주소값을 비교한다.  
동등성비교(equals()) : 객체 내부의 값을 비교한다.  
- JDBC  
데이터베이스의 같은 로우를 조회했지만 객체의 동일성 비교는 실패한다.  
객체 측면에서 둘은 다른 인스턴스이다.  

		Employee employee1 = empSpringJdbcRepository.findbyId(empNo);
		Employee employee2 = empSpringJdbcRepository.findbyId(empNo);
		
		assertEquals(true, employee1.equals(employee2));
		assertEquals(true, employee1 == employee2);  // false  

- JAVA Collections  
객체를 컬렉션에 저장했디먄 동일성 비교는 성공한다.

		List<String> lists = new ArrayList<>();
		
		String index1 = new String("1");
		String index2 = new String("1");
		lists.add(index1);
		lists.add(index2);
		
		String string1 = lists.get(0);
		String string2 = lists.get(0);
		
		assertEquals(true, string1.equals(string2));
		assertEquals(true, string1==string2);
- JPA  
JPA 는 같은 트랜잭션일때 같은 객체가 조회되는것을 보장한다. 

		Employee employee1 = empJpaRepository.findbyId(empNo );
		Employee employee2 = empJpaRepository.findbyId(empNo );
		
		assertEquals(true, employee1.equals(employee2));
		assertEquals(true, employee1 == employee2);	// true
## JPA  
- java persistence API : ORM 표준기술  
- 객체와 테이블을 매핑해서 패러다임의 불일치 문제를 대신 해결해준다.  
- 객체를 자바 컬렉션에 저장하듯이 ORM 프레임워크에 저장하면 적절한 SQL 을 생성해서 데이터베이스에 객체를 저장해준다.  
- 관계형 대이터베이스를 사용하며 객체지향 어플리케이션 개발에 집중 할수 있다.  
