import java.util.Scanner;

import images.*;

public class Enlarge {
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the image file name:");
		String fileName = reader.nextLine();
		APImage image = new APImage(fileName);
		System.out.println("Input enlargement factor:");
		int f = reader.nextInt();
		APImage Image = new APImage(image.getWidth() * f, image.getHeight() * f);
		//F is the enlargement factor
		//H and J are Counters
		for(int y = 0; y < image.getHeight(); y++){
			for(int x = 0; x < image.getWidth(); x++){
				for(int h = 0; h < f; h++){
					for(int j = 0; j < f; j++){
						Pixel p = image.getPixel(x , y);
						Pixel P = Image.getPixel(f * x + j, f * y + h);
						P.setRed(p.getRed());
						P.setGreen(p.getGreen());
						P.setBlue(p.getBlue());
					}
				}
			}
		}
		
		reader.nextLine();
		Image.draw();
		reader.close();
	}

}
