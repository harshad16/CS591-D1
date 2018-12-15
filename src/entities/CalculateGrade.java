package src.entities;

public class CalculateGrade {
	
	Object[][] grade = {
			{"A+",new Integer(95),new Integer(100)},
			{"A",new Integer(90),new Integer(95)},
			{"A-",new Integer(85),new Integer(90)},
			{"B+",new Integer(80),new Integer(85)},
			{"B",new Integer(75),new Integer(80)},
			{"B-",new Integer(70),new Integer(75)},
			{"C+",new Integer(65),new Integer(70)},
			{"C",new Integer(60),new Integer(65)},
			{"C-",new Integer(50),new Integer(60)},
			{"D",new Integer(35),new Integer(50)},
			{"F",new Integer(0),new Integer(35)},
	};

	public String grade(double grd) {
		for (int i=0; i< grade.length; i++) {
			if(grd > (Integer)grade[i][1] && grd <= (Integer)grade[i][2]) {
				return (String)grade[i][0];
			}
		}
		return "";
	}
	
//	public static void main() {
//		CalculateGrade g = new CalculateGrade();
//		g.grade();
//	}

}
