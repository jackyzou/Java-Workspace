
class check123 {

	    public static void main(String[] args) {
	        int num = 132;
	        int i = 1;
	        while (i< 20)
	        {
	            System.out.println("��" + i + "�� " + num);
	            int born = (int) (num * 0.03);
	            System.out.println("������ " + (num += born));
	            int death = (int) (num * 0.01);
	            System.out.println("������ " + (num -= death));
	            i++;
	        }
	    }
	}


