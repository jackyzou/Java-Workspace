
class check123 {

	    public static void main(String[] args) {
	        int num = 132;
	        int i = 1;
	        while (i< 20)
	        {
	            System.out.println("第" + i + "代 " + num);
	            int born = (int) (num * 0.03);
	            System.out.println("出生后 " + (num += born));
	            int death = (int) (num * 0.01);
	            System.out.println("死亡后 " + (num -= death));
	            i++;
	        }
	    }
	}


