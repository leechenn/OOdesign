//checked the Javadoc output and it was OK.
/** NetId: cl953, cy428. Time spent: 2 hour. 
    An instance maintains info about the PhD of a person. */


public class PhD {
	private String name; //Phd's name, length>1
	private int year; //any integer
	private int month; //Month PhD awarded, in range 1..12 with 1 being January, etc.
	private PhD firstAdvisor; //null if unknown
	private PhD secondAdvisor; //null if unknown or if the person has less than two advisor
	private int advisseNum; //number of PhD advisees of this person
	
	/**Constructor: an instance for a person with name name, PhD year year, and PhD month month. The advisors are unknown, and there are 0 advisees.
    Precondition: n has at least 2 chars, and m is in 1..12.*/
	public PhD(String name, int year, int month) {
		assert name.length()>=2&&month>=1&&month<=12;
		this.name = name;
		this.year = year;
		this.month = month;
		
	}
	
	/**Constructor: a PhD with name n, PhD year y, PhD month m, first advisor adv1, and no second advisor.
	Precondition: n has at least 2 chars, m is in 1..12, and adv1 is not null.*/
	public PhD(String name, int year, int month,PhD adv1) {
		assert name.length()>=2&&month>=1&&month<=12&&adv1!=null;
		this.name = name;
		this.year = year;
		this.month = month;
		this.firstAdvisor = adv1;
		adv1.advisseNum++;
	}
	
	/**Constructor: a PhD with name n, PhD year y, PhD month m, first advisor adv1, and second advisor adv2.
    Precondition: n has at least 2 chars, m is in 1..12,
    adv1 and adv2 are not null, and adv1 and adv2 are different.*/
	public PhD(String name, int year, int month,PhD adv1,PhD adv2) {
		assert name.length()>=2&&month>=1&&month<=12&&adv1!=null&&adv2!=null&&adv1!=adv2;
		this.name = name;
		this.year = year;
		this.month = month;
		this.firstAdvisor = adv1;
		this.secondAdvisor = adv2;
		adv1.advisseNum++;
		adv2.advisseNum++;
	}
	
	/**Return the name of this person.*/
	public String name() {
		return this.name;
	}
	
	/**Return the year this person got their PhD.*/
	public int year() {
		return this.year;
	}
	
	/**Return the month this person got their PhD.*/
	public int month() {
		return this.month;
	}
	
	/**Return the first advisor of this PhD (null if unknown).*/
	public PhD advisor1() {
		return this.firstAdvisor;
	}
	
	/**Return the second advisor of this PhD (null if unknown or non-existent).*/
	public PhD advisor2() {
		return this.secondAdvisor;
	}
	
	/**Return the number of PhD advisees of this person.*/
	public int numAdvisees() {
		return this.advisseNum;
	}
	
	/**Add p as the first advisor of this person.
     Precondition: the first advisor is unknown and p is not null.*/
	public void addAdvisor1(PhD p) {
		assert this.firstAdvisor==null&&p!=null;
		this.firstAdvisor=p;
		p.advisseNum = p.advisseNum+1;
	}
	
	/**Add p as the second advisor of this PhD.
	Precondition: The first advisor is known, the second advisor is unknown, p is not null, and p is different from the first advisor.*/
	public void addAdvisor2(PhD p) {
		assert this.firstAdvisor!=null&&this.secondAdvisor==null&&p!=null&&p!=this.firstAdvisor;
		this.secondAdvisor=p;
		p.advisseNum = p.advisseNum+1;
	}
	
	/**Return value of: p is not null and this PhD got the PhD before p.*/
	public boolean gotBefore(PhD p){
		
		return p!=null&&(this.year<p.year||(this.year==p.year&&this.month<p.month));
	}
	
	/**Return value of: this PhD is an intellectual sibling of p. Precondition: p is not null.*/
	public boolean isSiblingOf(PhD p){
		assert p!=null;
		boolean notNullAd1 = p.firstAdvisor!=null;
		boolean siblingC1 = p.firstAdvisor==this.firstAdvisor||p.firstAdvisor==this.secondAdvisor;
		boolean notNullAd2 = p.firstAdvisor!=null;
		boolean siblingC2 = p.secondAdvisor==this.firstAdvisor||p.secondAdvisor==this.secondAdvisor;
		
		
		return (this!=p)&&((notNullAd1&&siblingC1)||(notNullAd2&&siblingC2));
		
	}
	

	
}
	