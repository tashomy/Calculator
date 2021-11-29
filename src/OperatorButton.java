import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends Button implements ActionListener
{
    Calculator cl;

    //konstruktor
    OperatorButton(int x, int y, int width, int height, String cap, Calculator clc)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.cl=clc;
        this.cl.add(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent ev)
    {
        String opText=((OperatorButton)ev.getSource()).getLabel();

        cl.setClear=true;
        double temp=Double.parseDouble(cl.displayLabel.getText());


        if(opText.equals("√"))
        {
            double tempd=Math.sqrt(temp);
                cl.displayLabel.setText(Calculator.getFormattedText(tempd));
            return;
        }
        if(!opText.equals("="))
        {
            cl.number=temp;
            cl.op=opText.charAt(0);
            return;
        }

        switch(cl.op)
        {
            case '+':
                temp+=cl.number;break;
            case '-':
                temp=cl.number-temp;break;
            case '*':
                temp*=cl.number;break;
            case '%':
                try{temp=cl.number%temp;}
                catch(ArithmeticException excp)
                {cl.displayLabel.setText("Divide by 0."); return;}
                break;
            case '/':
                try{temp=cl.number/temp;}
                catch(ArithmeticException excp)
                {cl.displayLabel.setText("Divide by 0."); return;}
                break;
        }

        cl.displayLabel.setText(Calculator.getFormattedText(temp));

    }
}


