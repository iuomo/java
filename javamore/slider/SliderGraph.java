import java.awt.*;
import edu.hws.jcm.data.*;
import edu.hws.jcm.draw.*;
import edu.hws.jcm.awt.*;

public class SliderGraph extends java.applet.Applet {

   private DisplayCanvas canvas;
   
   public void stop() {
      canvas.releaseResources();
   }
   
   JCMPanel makeSliderPanel(VariableSlider v) {
         // A small utility routing that makes a JCMPanel that contains
         // a VariableSlider and a DisplayLabel that shows the value
         // of the variable associated with that slider.
      JCMPanel p = new JCMPanel();
      p.add(v, BorderLayout.CENTER);
      p.add( new DisplayLabel(v.getName() + " = #", new Value[] { v } ), BorderLayout.EAST);
      return p;
   }
   

   public void init() {
   
      Parser parser = new Parser();
      Variable x = new Variable("x");
      parser.add(x);
      
        // Create the three VariableSliders.  In this case, the sliders have
        //   names.  There is also a Variable associated with each slider, 
        //   which has the same name.  This variable is added to the parser
        //   which is passed as the fourth parameter to the constructor, making
        //   it possible to use "a", "b", and "c" in expressions parsed by the
        //   parser.  Adjusting the value on a slider changes the value of the
        //   associated variable, and therefore changes the value of any
        //   expression that refers to that variable.  The second and third
        //   parameters to the constructor give the minimum and maximum Values
        //   on the slider.  Passing "null,null" uses the defaults, namely
        //   new Constant(-5) and new Constant(5).
      VariableSlider a = new VariableSlider("a",null,null,parser);
      VariableSlider b = new VariableSlider("b",null,null,parser);
      VariableSlider c = new VariableSlider("c",null,null,parser);

      canvas = new DisplayCanvas();
      canvas.setHandleMouseZooms(true);
      canvas.add(new Panner());
      
      LimitControlPanel limits =
           new LimitControlPanel( LimitControlPanel.SET_LIMITS | LimitControlPanel.RESTORE
                                    | LimitControlPanel.EQUALIZE,  false);
      limits.addCoords(canvas);
      
      ExpressionInput input = new ExpressionInput("a*x^2 + b*x + c", parser);
      Graph1D graph = new Graph1D(input.getFunction(x));
      
      ComputeButton button = new ComputeButton("Graph it!");
      
      canvas.add(new Axes());
      canvas.add(graph);
      canvas.add(new DrawBorder(Color.darkGray, 2));
      
      JCMPanel main = new JCMPanel();  // Build interface out of JCMPanels!
      main.setInsetGap(3);
      main.add(canvas, BorderLayout.CENTER);
      main.add(limits, BorderLayout.EAST);
      JCMPanel bot = new JCMPanel(5,1);
      main.add(bot, BorderLayout.SOUTH);
      
      bot.add(new Label("Enter a function f(x), which can use the constants a, b, and c:"));
      JCMPanel inputPanel = new JCMPanel();
      bot.add(inputPanel);      
      inputPanel.add(input, BorderLayout.CENTER);
      inputPanel.add(button, BorderLayout.EAST);
      
      bot.add( makeSliderPanel(a) );  // Create and add the sliders.
      bot.add( makeSliderPanel(b) );
      bot.add( makeSliderPanel(c) );
      
      Controller controller = main.getController();  // Set up error reporting.
      controller.setErrorReporter(canvas);
      limits.setErrorReporter(canvas);

      main.gatherInputs();  // Set up main panel to respond to changes in input objects.
                            // This works since the interface is built of JCMPanels.  For
                            // the same reason, I don't have to add the objects the the
                            // controller.
                             
      button.setOnUserAction(controller);  // Set controller to respond to button.

      setBackground(Color.lightGray);
      setLayout(new BorderLayout());
      add(main,BorderLayout.CENTER);

   } // end init()
   
} // end class SliderGraph
import java.awt.*;
import edu.hws.jcm.data.*;
import edu.hws.jcm.draw.*;
import edu.hws.jcm.awt.*;

public class SliderGraph extends java.applet.Applet {

   private DisplayCanvas canvas;
   
   public void stop() {
      canvas.releaseResources();
   }
   
   JCMPanel makeSliderPanel(VariableSlider v) {
         // A small utility routing that makes a JCMPanel that contains
         // a VariableSlider and a DisplayLabel that shows the value
         // of the variable associated with that slider.
      JCMPanel p = new JCMPanel();
      p.add(v, BorderLayout.CENTER);
      p.add( new DisplayLabel(v.getName() + " = #", new Value[] { v } ), BorderLayout.EAST);
      return p;
   }
   

   public void init() {
   
      Parser parser = new Parser();
      Variable x = new Variable("x");
      parser.add(x);
      
        // Create the three VariableSliders.  In this case, the sliders have
        //   names.  There is also a Variable associated with each slider, 
        //   which has the same name.  This variable is added to the parser
        //   which is passed as the fourth parameter to the constructor, making
        //   it possible to use "a", "b", and "c" in expressions parsed by the
        //   parser.  Adjusting the value on a slider changes the value of the
        //   associated variable, and therefore changes the value of any
        //   expression that refers to that variable.  The second and third
        //   parameters to the constructor give the minimum and maximum Values
        //   on the slider.  Passing "null,null" uses the defaults, namely
        //   new Constant(-5) and new Constant(5).
      VariableSlider a = new VariableSlider("a",null,null,parser);
      VariableSlider b = new VariableSlider("b",null,null,parser);
      VariableSlider c = new VariableSlider("c",null,null,parser);

      canvas = new DisplayCanvas();
      canvas.setHandleMouseZooms(true);
      canvas.add(new Panner());
      
      LimitControlPanel limits =
           new LimitControlPanel( LimitControlPanel.SET_LIMITS | LimitControlPanel.RESTORE
                                    | LimitControlPanel.EQUALIZE,  false);
      limits.addCoords(canvas);
      
      ExpressionInput input = new ExpressionInput("a*x^2 + b*x + c", parser);
      Graph1D graph = new Graph1D(input.getFunction(x));
      
      ComputeButton button = new ComputeButton("Graph it!");
      
      canvas.add(new Axes());
      canvas.add(graph);
      canvas.add(new DrawBorder(Color.darkGray, 2));
      
      JCMPanel main = new JCMPanel();  // Build interface out of JCMPanels!
      main.setInsetGap(3);
      main.add(canvas, BorderLayout.CENTER);
      main.add(limits, BorderLayout.EAST);
      JCMPanel bot = new JCMPanel(5,1);
      main.add(bot, BorderLayout.SOUTH);
      
      bot.add(new Label("Enter a function f(x), which can use the constants a, b, and c:"));
      JCMPanel inputPanel = new JCMPanel();
      bot.add(inputPanel);      
      inputPanel.add(input, BorderLayout.CENTER);
      inputPanel.add(button, BorderLayout.EAST);
      
      bot.add( makeSliderPanel(a) );  // Create and add the sliders.
      bot.add( makeSliderPanel(b) );
      bot.add( makeSliderPanel(c) );
      
      Controller controller = main.getController();  // Set up error reporting.
      controller.setErrorReporter(canvas);
      limits.setErrorReporter(canvas);

      main.gatherInputs();  // Set up main panel to respond to changes in input objects.
                            // This works since the interface is built of JCMPanels.  For
                            // the same reason, I don't have to add the objects the the
                            // controller.
                             
      button.setOnUserAction(controller);  // Set controller to respond to button.

      setBackground(Color.lightGray);
      setLayout(new BorderLayout());
      add(main,BorderLayout.CENTER);

   } // end init()
   
} // end class SliderGraph

