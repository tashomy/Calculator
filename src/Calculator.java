import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame {
    public boolean setClear=true;
    double number;
    char op;

    String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "", "." };
    String operatorButtonText[] = {"/", "√", "*", "%", "-", "+", "", "=" };
    String specialButtonText[] = {"<<<", "C", "", "!" };

    DigitButton digitButton[]=new DigitButton[digitButtonText.length];
    OperatorButton operatorButton[]=new OperatorButton[operatorButtonText.length];
    SpecialButton specialButton[]=new SpecialButton[specialButtonText.length];

    Label displayLabel=new Label("0",Label.RIGHT);

    final int HEIGHT=60, WIDTH=80, H_SPACE=10,V_SPACE=10;
    final int TOPX=30, TOPY=50;
    final int FRAME_WIDTH=6*WIDTH+6*V_SPACE+TOPY,FRAME_HEIGHT=530;

    Calculator(String frameText)//constructor
    {
        super(frameText);

        setBackground(new Color(214, 214, 194));

        int tempX=TOPX, y=TOPY;
        displayLabel.setBounds(tempX,y,540,HEIGHT);
        displayLabel.setBackground(new Color(194, 194, 163));
        displayLabel.setForeground(new Color(92, 92, 61));
        displayLabel.setFont(new Font("Vedrana", Font.PLAIN, 35));

        add(displayLabel);

// koordinate za specijalne tastere
        tempX=TOPX;
        y=TOPY+2*(HEIGHT+V_SPACE);

        specialButton[0]=new SpecialButton(tempX,y,WIDTH,HEIGHT,specialButtonText[0], this);
        specialButton[0].setBackground(new Color(92, 92, 61));
        specialButton[0].setFont(new Font("Vedrana", Font.PLAIN, 20));
        specialButton[0].setForeground(Color.WHITE);
        y+=HEIGHT+V_SPACE;

        specialButton[1]=new SpecialButton(tempX,y,WIDTH,HEIGHT*2+H_SPACE,specialButtonText[1], this);
        specialButton[1].setBackground(new Color(92, 92, 61));
        specialButton[1].setFont(new Font("Vedrana", Font.PLAIN, 20));
        specialButton[1].setForeground(Color.WHITE);
        y+=HEIGHT+V_SPACE;

        specialButton[2]=new SpecialButton(tempX,y,WIDTH,HEIGHT,specialButtonText[2], this);
        specialButton[2].setBackground(new Color(92, 92, 61));
        specialButton[2].setFont(new Font("Vedrana", Font.PLAIN, 20));
        specialButton[2].setForeground(Color.WHITE);
        y+=HEIGHT+V_SPACE;

        specialButton[3]=new SpecialButton(tempX,y,WIDTH,HEIGHT,specialButtonText[3], this);
        specialButton[3].setBackground(new Color(92, 92, 61));
        specialButton[3].setFont(new Font("Vedrana", Font.PLAIN, 20));
        specialButton[3].setForeground(Color.WHITE);
        y+=HEIGHT+V_SPACE;

//koordinate za tastere sa ciframa
        int digitX=TOPX+WIDTH+H_SPACE;
        int digitY=TOPY+2*(HEIGHT+V_SPACE);
        tempX=digitX;  y=digitY;
        for(int i=0;i<9;i++)
        {
            digitButton[i]=new DigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[i], this);
            digitButton[i].setForeground(Color.WHITE);
            digitButton[i].setFont(new Font("Vedrana", Font.PLAIN, 20));
            tempX+=WIDTH+H_SPACE;
            if((i+1)%3==0){tempX=digitX; y+=HEIGHT+V_SPACE;}
        }
        digitButton[9]=new DigitButton(tempX,y,WIDTH*2+H_SPACE,HEIGHT,digitButtonText[9], this);
        digitButton[9].setForeground(Color.WHITE);
        digitButton[9].setFont(new Font("Vedrana", Font.PLAIN, 20));
        tempX+=WIDTH+H_SPACE;

        digitButton[10]=new DigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[10], this);
        digitButton[10].setForeground(Color.WHITE);
        digitButton[10].setFont(new Font("Vedrana", Font.PLAIN, 20));
        tempX+=WIDTH+H_SPACE;

        digitButton[11]=new DigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[11], this);
        digitButton[11].setForeground(Color.WHITE);
        digitButton[11].setFont(new Font("Vedrana", Font.PLAIN, 20));
        tempX+=WIDTH+H_SPACE;

//koordinate za operator tastere
        int opsX=digitX+2*(WIDTH+H_SPACE)+H_SPACE;
        int opsY=digitY;
        tempX=opsX;  y=opsY;
        for(int i=0;i<operatorButton.length-2;i++)
        {
            tempX+=WIDTH+H_SPACE;
            operatorButton[i]=new OperatorButton(tempX,y,WIDTH,HEIGHT,operatorButtonText[i], this);
            operatorButton[i].setBackground(new Color(92, 92, 61));
            operatorButton[i].setFont(new Font("Vedrana", Font.PLAIN, 20));
            operatorButton[i].setForeground(Color.WHITE);
            if((i+1)%2==0){tempX=opsX; y+=HEIGHT+V_SPACE;}
        }
        tempX+=WIDTH+H_SPACE;
        operatorButton[operatorButton.length-1]=new OperatorButton(tempX,y,WIDTH*2+H_SPACE,HEIGHT,operatorButtonText[operatorButton.length-1], this);
        operatorButton[operatorButton.length-1].setBackground(new Color(92, 92, 61));
        operatorButton[operatorButton.length-1].setFont(new Font("Vedrana", Font.PLAIN, 20));
        operatorButton[operatorButton.length-1].setForeground(Color.WHITE);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent ev)
            {System.exit(0);}
        });

        setLayout(null);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setResizable(false);
        setVisible(true);
    }

    static String getFormattedText(double temp)
    {
        String resText=""+temp;
        if(resText.lastIndexOf(".0")>0)
            resText=resText.substring(0,resText.length()-2);
        return resText;
    }

}
