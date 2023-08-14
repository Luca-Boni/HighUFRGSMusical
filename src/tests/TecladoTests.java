// package tests;

// import static org.junit.Assert.assertArrayEquals;
// import static org.junit.Assert.assertEquals;
// import implementacao.Tecla;
// import implementacao.Teclado;
// import com.raylib.Jaylib;


// import java.util.ArrayList;

// import java.awt.AWTException;

// import java.awt.event.KeyEvent;
// import org.junit.Test;
// import java.awt.Robot;

// public class TecladoTests {
//     @Test
//     public void TecladoTest() {
//         try{
//             Robot robot = new Robot();
//             Jaylib.InitWindow(800, 400, "Teste Teclado");
//             Jaylib.SetTargetFPS(240);
//             while(!Jaylib.WindowShouldClose()){
//                 ArrayList<Tecla> teclas = new ArrayList<Tecla>();
//                 teclas.add(new Tecla('a', false));
//                 robot.keyPress(KeyEvent.VK_A);
//                 assertEquals(true, Jaylib.IsKeyPressed('a'));
//                 robot.keyRelease(KeyEvent.VK_A);
//                 robot.keyPress(KeyEvent.VK_ESCAPE);
//                 Jaylib.BeginDrawing();
//                 Jaylib.EndDrawing();
//             }
//             robot.keyRelease(KeyEvent.VK_ESCAPE);
//             Jaylib.CloseWindow();
            
//         }catch(AWTException e){
//             e.printStackTrace();
//         }

//     }
// }
