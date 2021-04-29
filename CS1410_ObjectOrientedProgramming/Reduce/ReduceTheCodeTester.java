/**
 * 
 * @author Dr. B.
 *
 */
public class ReduceTheCodeTester {

	public static void main(String[] args) {
		//Test the constructor
		System.out.println("Starting the tester");
		ReduceTheCode r1 = new ReduceTheCode();
		ReduceTheCode r2 = new ReduceTheCode();
		boolean getFooError = false;
		for (int i = 0; i < 1000; i++){
			ReduceTheCode tmp = new ReduceTheCode();
			//Test the getFoo method
			if (tmp.getFoo() != 5 && getFooError == false){
				getFooError = true;
				System.out.println("Error with getFoo");
			}
		}

		
		//Test the setVariables
		boolean setVariablesWorks = true;
		for (int i = 0; i < 30; i++){
			int num = (int)(Math.random()*1000);
			r1.setVariables(num);
			r2.setVariables(num);
			if (setVariablesWorks && (r1.getFoo() != num || r2.getFoo() != num)){
				setVariablesWorks = false;
				System.out.println("Error with getFoo - after setting");
			}
		}

		//Test the static a(i) method
		if(ReduceTheCode.a(0) != 12){
			System.out.println("Error with ReduceTheCode.a(0) = " + ReduceTheCode.a(0) + " not 12");
		}
		else if(ReduceTheCode.a(1) != 13){
			System.out.println("Error with ReduceTheCode.a(1) = " + ReduceTheCode.a(1) + " not 13");
		}
		else if(ReduceTheCode.a(2) != 14){
			System.out.println("Error with ReduceTheCode.a(2) = " + ReduceTheCode.a(2) + " not 14");
		}
		else if(ReduceTheCode.a(3) != 15){
			System.out.println("Error with ReduceTheCode.a(3) = " + ReduceTheCode.a(3) + " not 15");
		}
		else if(ReduceTheCode.a(4) != 16){
			System.out.println("Error with ReduceTheCode.a(4) = " + ReduceTheCode.a(4) + " not 16");
		}
		else if(ReduceTheCode.a(5) != 17){
			System.out.println("Error with ReduceTheCode.a(5) = " + ReduceTheCode.a(5) + " not 17");
		}
		else if(ReduceTheCode.a(6) != 18){
			System.out.println("Error with ReduceTheCode.a(6) = " + ReduceTheCode.a(6) + " not 18");
		}
		else if(ReduceTheCode.a(7) != 19){
			System.out.println("Error with ReduceTheCode.a(7) = " + ReduceTheCode.a(7) + " not 19");
		}
		else if(ReduceTheCode.a(8) != 20){
			System.out.println("Error with ReduceTheCode.a(8) = " + ReduceTheCode.a(8) + " not 20");
		}
		else if(ReduceTheCode.a(9) != 21){
			System.out.println("Error with ReduceTheCode.a(9) = " + ReduceTheCode.a(9) + " not 21");
		}
		else if(ReduceTheCode.a(10) != 22){
			System.out.println("Error with ReduceTheCode.a(10) = " + ReduceTheCode.a(10) + " not 22");
		}
		else if(ReduceTheCode.a(11) != 23){
			System.out.println("Error with ReduceTheCode.a(11) = " + ReduceTheCode.a(11) + " not 23");
		}
		else if(ReduceTheCode.a(12) != 24){
			System.out.println("Error with ReduceTheCode.a(12) = " + ReduceTheCode.a(12) + " not 24");
		}
		else if(ReduceTheCode.a(13) != 25){
			System.out.println("Error with ReduceTheCode.a(13) = " + ReduceTheCode.a(13) + " not 25");
		}
		else if(ReduceTheCode.a(14) != 26){
			System.out.println("Error with ReduceTheCode.a(14) = " + ReduceTheCode.a(14) + " not 26");
		}
		else if(ReduceTheCode.a(15) != 27){
			System.out.println("Error with ReduceTheCode.a(15) = " + ReduceTheCode.a(15) + " not 27");
		}
		else if(ReduceTheCode.a(16) != 28){
			System.out.println("Error with ReduceTheCode.a(16) = " + ReduceTheCode.a(16) + " not 28");
		}
		else if(ReduceTheCode.a(17) != 29){
			System.out.println("Error with ReduceTheCode.a(17) = " + ReduceTheCode.a(17) + " not 29");
		}
		else if(ReduceTheCode.a(18) != 30){
			System.out.println("Error with ReduceTheCode.a(18) = " + ReduceTheCode.a(18) + " not 30");
		}
		else if(ReduceTheCode.a(19) != 31){
			System.out.println("Error with ReduceTheCode.a(19) = " + ReduceTheCode.a(19) + " not 31");
		}
		else if(ReduceTheCode.a(20) != 32){
			System.out.println("Error with ReduceTheCode.a(20) = " + ReduceTheCode.a(20) + " not 32");
		}
		//Test other numbers
		else if (ReduceTheCode.a(-10) != -1){
			System.out.println("Error with ReduceTheCode.a(-10) = " + ReduceTheCode.a(-10) + " not -1");
		}
		else if (ReduceTheCode.a(100) != -1){
			System.out.println("Error with ReduceTheCode.a(100) = " + ReduceTheCode.a(100) + " not -1");
		}


		//Test the static b(i) method
		if(ReduceTheCode.b(0) != 3493){
			System.out.println("Error with ReduceTheCode.b(0) = " + ReduceTheCode.b(0) + " not 3493");
		}
		else if(ReduceTheCode.b(1) != 3011){
			System.out.println("Error with ReduceTheCode.b(1) = " + ReduceTheCode.b(1) + " not 3011");
		}
		else if(ReduceTheCode.b(2) != 6881){
			System.out.println("Error with ReduceTheCode.b(2) = " + ReduceTheCode.b(2) + " not 6881");
		}
		else if(ReduceTheCode.b(3) != 5413){
			System.out.println("Error with ReduceTheCode.b(3) = " + ReduceTheCode.b(3) + " not 5413");
		}
		else if(ReduceTheCode.b(4) != 2144){
			System.out.println("Error with ReduceTheCode.b(4) = " + ReduceTheCode.b(4) + " not 2144");
		}
		else if(ReduceTheCode.b(5) != 1728){
			System.out.println("Error with ReduceTheCode.b(5) = " + ReduceTheCode.b(5) + " not 1728");
		}
		else if(ReduceTheCode.b(6) != 8383){
			System.out.println("Error with ReduceTheCode.b(6) = " + ReduceTheCode.b(6) + " not 8383");
		}
		else if(ReduceTheCode.b(7) != 2970){
			System.out.println("Error with ReduceTheCode.b(7) = " + ReduceTheCode.b(7) + " not 2970");
		}
		else if(ReduceTheCode.b(8) != 8226){
			System.out.println("Error with ReduceTheCode.b(8) = " + ReduceTheCode.b(8) + " not 8226");
		}
		else if(ReduceTheCode.b(9) != 2396){
			System.out.println("Error with ReduceTheCode.b(9) = " + ReduceTheCode.b(9) + " not 2396");
		}
		else if(ReduceTheCode.b(10) != 4106){
			System.out.println("Error with ReduceTheCode.b(10) = " + ReduceTheCode.b(10) + " not 4106");
		}
		else if(ReduceTheCode.b(11) != 9201){
			System.out.println("Error with ReduceTheCode.b(11) = " + ReduceTheCode.b(11) + " not 9201");
		}
		else if(ReduceTheCode.b(12) != 9582){
			System.out.println("Error with ReduceTheCode.b(12) = " + ReduceTheCode.b(12) + " not 9582");
		}
		else if(ReduceTheCode.b(13) != 7412){
			System.out.println("Error with ReduceTheCode.b(13) = " + ReduceTheCode.b(13) + " not 7412");
		}
		else if(ReduceTheCode.b(14) != 4091){
			System.out.println("Error with ReduceTheCode.b(14) = " + ReduceTheCode.b(14) + " not 4091");
		}
		else if(ReduceTheCode.b(15) != 7291){
			System.out.println("Error with ReduceTheCode.b(15) = " + ReduceTheCode.b(15) + " not 7291");
		}
		else if(ReduceTheCode.b(16) != 1747){
			System.out.println("Error with ReduceTheCode.b(16) = " + ReduceTheCode.b(16) + " not 1747");
		}
		else if(ReduceTheCode.b(17) != 9922){
			System.out.println("Error with ReduceTheCode.b(17) = " + ReduceTheCode.b(17) + " not 9922");
		}
		else if(ReduceTheCode.b(18) != 4647){
			System.out.println("Error with ReduceTheCode.b(18) = " + ReduceTheCode.b(18) + " not 4647");
		}
		else if(ReduceTheCode.b(19) != 6070){
			System.out.println("Error with ReduceTheCode.b(19) = " + ReduceTheCode.b(19) + " not 6070");
		}
		else if(ReduceTheCode.b(20) != 9946){
			System.out.println("Error with ReduceTheCode.b(20) = " + ReduceTheCode.b(20) + " not 9946");
		}
		//Test other numbers
		else if (ReduceTheCode.b(-10) != -1){
			System.out.println("Error with ReduceTheCode.b(-10) = " + ReduceTheCode.b(-10) + " not -1");
		}
		else if (ReduceTheCode.b(100) != -1){
			System.out.println("Error with ReduceTheCode.b(100) = " + ReduceTheCode.b(100) + " not -1");
		}

		//Test the static c(i) method
		int i = 0;
		ReduceTheCode.c(0);
		i += 7221;
		if(i != 7221){
			System.out.println("Error with ReduceTheCode.c(0) not 3493");
		}
		i = 5084;
		ReduceTheCode.c(1);
		if(i != 5084){
			System.out.println("Error with ReduceTheCode.c(1) not 3011");
		}
		i = 9790;
		ReduceTheCode.c(2);
		if(i != 9790){
			System.out.println("Error with ReduceTheCode.c(2) not 6881");
		}
		i = 7601;
		ReduceTheCode.c(3);
		if(i != 7601){
			System.out.println("Error with ReduceTheCode.c(3) not 5413");
		}
		i = 2951;
		ReduceTheCode.c(4);
		if(i != 2951){
			System.out.println("Error with ReduceTheCode.c(4) not 2144");
		}
		i = 1854;
		ReduceTheCode.c(5);
		if(i != 1854){
			System.out.println("Error with ReduceTheCode.c(5) not 1728");
		}
		i = 1372;
		ReduceTheCode.c(6);
		if(i != 1372){
			System.out.println("Error with ReduceTheCode.c(6) not 8383");
		}
		i = 5874;
		ReduceTheCode.c(7);
		if(i != 5874){
			System.out.println("Error with ReduceTheCode.c(7) not 2970");
		}
		i = 2996;
		ReduceTheCode.c(8);
		if(i != 2996){
			System.out.println("Error with ReduceTheCode.c(8) not 8226");
		}
		i = 5345;
		ReduceTheCode.c(9);
		if(i != 5345){
			System.out.println("Error with ReduceTheCode.c(9) not 2396");
		}
		i = 5358;
		ReduceTheCode.c(10);
		if(i != 5358){
			System.out.println("Error with ReduceTheCode.c(10) not 4106");
		}
		i = 4542;
		ReduceTheCode.c(11);
		if(i != 4542){
			System.out.println("Error with ReduceTheCode.c(11) not 9201");
		}
		i = 3103;
		ReduceTheCode.c(12);
		if(i != 3103){
			System.out.println("Error with ReduceTheCode.c(12) not 9582");
		}
		i = 2730;
		ReduceTheCode.c(13);
		if(i != 2730){
			System.out.println("Error with ReduceTheCode.c(13) not 7412");
		}
		i = 1972;
		ReduceTheCode.c(14);
		if(i != 1972){
			System.out.println("Error with ReduceTheCode.c(14) not 4091");
		}
		i = 2703;
		ReduceTheCode.c(15);
		if(i != 2703){
			System.out.println("Error with ReduceTheCode.c(15) not 7291");
		}
		i = 1661;
		ReduceTheCode.c(16);
		if(i != 1661){
			System.out.println("Error with ReduceTheCode.c(16) not 1747");
		}
		i = 6783;
		ReduceTheCode.c(17);
		if(i != 6783){
			System.out.println("Error with ReduceTheCode.c(17) not 9922");
		}
		i = 4094;
		ReduceTheCode.c(18);
		if(i != 4094){
			System.out.println("Error with ReduceTheCode.c(18) not 4647");
		}
		i = 3128;
		ReduceTheCode.c(19);
		if(i != 3128){
			System.out.println("Error with ReduceTheCode.c(19) not 6070");
		}
		i = -1;
		ReduceTheCode.c(-10);
		//Test other numbers
		if(i != -1){
			System.out.println("Error with ReduceTheCode.c(-10) not -1");
		}
		i = -1;
		ReduceTheCode.c(100);
		if(i != -1){
			System.out.println("Error with ReduceTheCode.c(100) not -1");
		}

		System.out.println("Testing completed");

	}

}


