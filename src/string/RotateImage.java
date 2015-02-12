// Rotate the image by 90 degree, which direction?
// Do this in place

package string;

public class RotateImage {
	public static void rotate(int[][] image, int n) {
		for(int i=0; i<n/2; i++) {
			int first = i;
			int last = n - 1 - i;
			for(int j=i; j<last; j++) {
				int diff = i - first;
				int top = image[first][i];
				image[first][i] = image[last-diff][first];
				image[last-diff][first] = image[last][last-diff];
				image[last][last-diff] = image[i][last];
				image[i][last] = top;
			}
		}
	}
}