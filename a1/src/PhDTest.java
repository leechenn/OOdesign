
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhDTest {

	@Test
	void testConstructor1() {
		PhD phd = new PhD("chen",1993,1);
		assertEquals("chen", phd.name());
		assertEquals(1993, phd.year());
		assertEquals(1, phd.month());
		assertEquals(null, phd.advisor1());
		assertEquals(null, phd.advisor2());
		assertEquals(0, phd.numAdvisees());
//		assertThrows(AssertionError.class,()->{new PhD("chen",1993,1);});
//		assertThrows(AssertionError.class,()->{new PhD("chen",1993,0);});
	}
	@Test
	void testSetterMethods() {
		PhD phd = new PhD("chen",1993,1);
		PhD phdAdv1 = new PhD("chen1",1992,2);
		PhD phdAdv2 = new PhD("chen2",1992,2);
		phd.addAdvisor1(phdAdv1);
		phd.addAdvisor2(phdAdv2);
		assertEquals(1, phdAdv1.numAdvisees());
		assertEquals(1, phdAdv2.numAdvisees());
		assertEquals(phd.advisor1(), phdAdv1);
		assertEquals(phd.advisor2(), phdAdv2);
		
	}
	@Test
	void testTwoMoreConstructors() {
		PhD phd1 = new PhD("chen",1993,1);
		PhD phd2 = new PhD("chen1",1993,2);
		PhD phd3 = new PhD("chen2",1993,3,phd1);
		PhD phd4 = new PhD("chen3",1993,3,phd1,phd2);
		assertEquals(phd3.advisor1(), phd1);
		assertEquals(phd3.advisor2(), null);
		assertEquals(phd3.name(),"chen2" );
		assertEquals(phd3.month(),3 );
		assertEquals(phd3.year(),1993 );
		assertEquals(phd3.numAdvisees(),0 );
		assertEquals(phd4.advisor1(), phd1);
		assertEquals(phd4.advisor2(), phd2);
		assertEquals(phd4.name(),"chen3" );
		assertEquals(phd4.month(),3 );
		assertEquals(phd4.year(),1993 );
		assertEquals(phd4.numAdvisees(),0 );
		assertEquals(phd1.numAdvisees(),2 );
		assertEquals(phd2.numAdvisees(),1 );
		
	}
	@Test
	void testgotBeforeandisSibling() {
		PhD p1= new PhD("feb77", 1977, 2);
		PhD p2= new PhD("jun77", 1977, 6);
		PhD p3= new PhD("feb77", 1977, 2);
		PhD p4= new PhD("feb67", 1967, 2);
		PhD p5= new PhD("sep67", 1967, 9);
		PhD p = null; 
		//p is null
		assertEquals(false, p1.gotBefore(p)); 
		//same year, same month
		assertEquals(false, p1.gotBefore(p3)); 
		//same year, this month before p's
		assertEquals(true, p1.gotBefore(p2)); 
		//same year, this month after p's
		assertEquals(false, p2.gotBefore(p3)); 
		//this year before p's, same month
		assertEquals(true, p4.gotBefore(p1)); 
		//this year before p's, this month before p's
		assertEquals(true, p4.gotBefore(p2)); 
		//this year before p's, this month after p's
		assertEquals(true, p5.gotBefore(p1)); 
		//this year after p's , same month.
		assertEquals(false, p1.gotBefore(p4)); 
		//this year after p's, this month before p's
		assertEquals(false, p1.gotBefore(p5)); 
		//this year after p's, this month after. p's
		assertEquals(false, p2.gotBefore(p4));
		PhD phd1 = new PhD("chen",1993,1);
		PhD phd2 = new PhD("chen1",1993,2);
		PhD phd3 = new PhD("chen2",1993,3,phd1);
		PhD phd4 = new PhD("chen3",1993,3,phd1,phd2);
		PhD phd5 = new PhD("chen4",1993,3,phd2,phd1);
		PhD phd6 = new PhD("chen5",1993,3,phd1,phd2);
		assertEquals(false, phd1.isSiblingOf(phd1)); //A and B are the same object
		assertEquals(false, phd1.isSiblingOf(phd2)); //Neither A nor B has an advisor
		assertEquals(true, phd3.isSiblingOf(phd4)); //A.advisor1 is not null and equals B.advisor1
		assertEquals(true, phd3.isSiblingOf(phd5)); //A.advisor1 is not null and equals B.advisor2
		assertEquals(true, phd4.isSiblingOf(phd5)); //A.advisor2 is not null and equals B.advisor1
		assertEquals(true, phd4.isSiblingOf(phd6)); //A.advisor2 is not null and equals B.advisor2
		
		
	}
	@Test
	void assertStatements(){
		PhD phd1 = new PhD("chen",1993,1);
		PhD phd2 = new PhD("chen1",1993,2);
		PhD phd3 = new PhD("chen2",1993,3,phd1);
		PhD phd4 = new PhD("chen3",1993,3,phd1,phd2);
		assertThrows(AssertionError.class,()->{new PhD("c",1993,1);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,0);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,1,null);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,0,phd1);});
		assertThrows(AssertionError.class,()->{new PhD("c",1993,1,phd1);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,0,phd1,phd2);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,1,phd1,phd1);});
		assertThrows(AssertionError.class,()->{new PhD("c",1993,1,phd1,phd2);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,1,null,phd2);});
		assertThrows(AssertionError.class,()->{new PhD("ch",1993,1,phd1,null);});
		assertThrows(AssertionError.class,()->{phd3.addAdvisor1(phd1);});
		assertThrows(AssertionError.class,()->{phd3.addAdvisor1(null);});
		assertThrows(AssertionError.class,()->{phd1.addAdvisor2(phd2);});
		assertThrows(AssertionError.class,()->{phd4.addAdvisor2(phd1);});
		assertThrows(AssertionError.class,()->{phd3.addAdvisor2(null);});
		assertThrows(AssertionError.class,()->{phd3.addAdvisor2(phd1);});
		assertThrows(AssertionError.class,()->{phd1.isSiblingOf(null);});
		
	}

}
