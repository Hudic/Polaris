package polaris.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class ImageUtil {
	private static final int width = 140;
	private static final int height = 40;
	private static final Random r = new Random();
	private static final char[] c = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private ImageUtil() {
	}

	public static final String getRandomStr(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = r.nextInt(c.length);
			sb.append(c[index]);
		}
		return sb.toString();
	}

	public static final BufferedImage createImage(HttpSession session, int length) {
//		Bitmap image = new Bitmap(100, 30);

		// BufferedImage
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 画笔
		Graphics g = bi.getGraphics();
		Graphics2D g2D = (Graphics2D) g;
		// 设置画笔颜色
		g2D.setColor(Color.WHITE);
		// 填充
		g2D.fillRect(0, 0, width, height);
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		// 循环四次
		for (int i = 0; i < length; i++) {
			// 取随机下标，可重复
			int index = r.nextInt(c.length);
			// 拼接到字符串
			sb.append(c[index]);
			// 画笔设置字体样式
			g2D.setFont(new Font("fantasy", r.nextInt(10) > 5 ? Font.ITALIC : Font.BOLD, r.nextInt(5) + 30));
			// 画笔更换颜色
			g2D.setColor(new Color(r.nextInt(150) + 50, r.nextInt(150) + 50, r.nextInt(150) + 50));
			// 旋转
			int t = r.nextInt(2);
			t = r.nextBoolean() ? t : -t;
			g2D.rotate(t, (width / 12) * (2 * i + 1), height / 2);
			// 把字符串（单个字符）画出来
			g2D.drawString(Character.toString(c[index]), i * width / 6 + 5, r.nextInt(20) + 20);
			// 画笔归正
			g2D.rotate(t * (-1), (width / 12) * (2 * i + 1), height / 2);
			// 画直线
			g2D.setFont(new Font("fantasy", Font.PLAIN, r.nextInt(5) + 5));
			g2D.drawLine(0, r.nextInt(height), width, r.nextInt(height));
			g2D.draw3DRect(0, 0, i, t, true);
			g2D.drawLine(r.nextInt(width), 0, r.nextInt(width), height);
			RoundRectangle2D rr = new RoundRectangle2D.Double(r.nextDouble() + r.nextInt(width/2),
					r.nextDouble() + r.nextInt(height/2), r.nextDouble() + r.nextInt(width),
					r.nextDouble() + r.nextInt(height), r.nextDouble()+10, r.nextDouble()+10);
			g2D.draw(rr);
			
		}
		// 将验证码的字符串值保存在session中，用于比较输入的验证码
		session.setAttribute("identifier", sb.toString());
		// 销毁程序中指定的图形界面资源（画笔）
		g.dispose();
		return bi;
	}
}
