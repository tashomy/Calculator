import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialButton extends Button implements ActionListener
{
    Calculator cl;

    //konstruktor
    SpecialButton(int x, int y, int width, int height, String cap, Calculator clc)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.cl=clc;
        this.cl.add(this);
        addActionListener(this);
    }

    static String backSpace(String s)
    {
        String Res="";
        for(int i=0; i<s.length()-1; i++) Res+=s.charAt(i);
        return Res;
    }
    public void actionPerformed(ActionEvent ev)
    {
        String opText=((SpecialButton)ev.getSource()).getLabel();
//provjeravamo da li je selektovan taster za brisanje
        if(opText.equals("<<<"))
        {
            String tempText=backSpace(cl.displayLabel.getText());
            if(tempText.equals(""))
                cl.displayLabel.setText("0");
            else
                cl.displayLabel.setText(tempText);
            return;
        }
        double temp=Double.parseDouble(cl.displayLabel.getText());
        //provjeravamo da li je izabran faktorijel
        if(opText.equals("!"))
        {
            double tempd = 1;
            for(int i = 1; i <= temp; i++){
                tempd = tempd * i;
            }
            cl.displayLabel.setText(Calculator.getFormattedText(tempd));
            return;
        }

//inace mora biti taster C
        cl.displayLabel.setText("0");cl.setClear=true;
    }
}
