import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class hintTextField extends JTextField implements FocusListener {

	    private final String hint;

	    public hintTextField(final String hint)
	    {
	        super(hint);
	        this.hint = hint;
	        super.addFocusListener(this);
	        
	        this.setHorizontalAlignment(CENTER);
	    }
	    
	    public void setUsable(boolean b)
	    {
	    	if (b == true)
	    	{
	    	this.setVisible(true);
	    	this.setEnabled(true);
	    	}
	    	else
	    	{
	    		this.setVisible(false);
		    	this.setEnabled(false);
	    	}
	    }


	    @Override
	    public String getText()
	    {
	        String typed = super.getText();
	        return typed.equals(hint) ? "" : typed;
	    }

		@Override
		public void focusGained(FocusEvent arg0)
		{
			if(this.getText().isEmpty()) {
	            super.setText("");
	        }
		}

		@Override
		public void focusLost(FocusEvent arg0)
		{
			if(this.getText().isEmpty()) {
	            super.setText(hint);
	        }
		}
	}