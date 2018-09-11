package capcha;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/img")
public class ImageController {
    
    /*
     * 随机数
     */
    private static Random random = new Random();

    @RequestMapping( method = GET)
    public void send(HttpServletRequest request, HttpServletResponse response) throws IOException   {
       
        String randomString = getRandomString();
   
        int width = 120;
        int height = 35;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 25);
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
         
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }
    
    /*
     * 随机字符字典
     */
    private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
        '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
        'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
 
    
    /*
     * 获取5位随机数
     */
    private static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }
    
    /*
     * 获取随机数颜色
     */
    private static Color getRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    
    /*
     * 返回某颜色的反色
     */
    private static Color getReverseColor(Color c) {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }
    
}
