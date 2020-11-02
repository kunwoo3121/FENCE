import java.util.Scanner;

public class FENCE {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int c; 
		
		c = sc.nextInt();
		
		for(int i = 0; i < c; i++)
		{
			int n, max;
			
			n = sc.nextInt();
			
			int[] fence = new int[n];
			
			for(int j = 0; j < n; j++)
			{
				fence[j] = sc.nextInt();
			}
			
			max = Fence(fence, 0, n-1);
			
			System.out.println(max);
			
		}
	}
	
	public static int Fence(int[] fence, int left, int right)
	{
		int tmp;
		
		if(left == right) return fence[left];
		
		int mid = (left + right) / 2;
		
		tmp = Math.max(Fence(fence, left, mid), Fence(fence, mid + 1, right));
		
		int low = mid, high = mid + 1;
		
		int height = Math.min(fence[low], fence[high]);
		
		tmp = Math.max(tmp, height * 2);
		
		while (left < low || high < right)
		{
			if(high < right && (low == left || fence[low - 1] < fence[high + 1]))
			{
				high++;
				height = Math.min(height, fence[high]);
			}
			
			else
			{
				low--;
				height = Math.min(height, fence[low]);
			}
			
			tmp = Math.max(tmp, height * (high - low +1));
		}
		
		return tmp;
	}
	
}
