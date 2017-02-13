/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JTextArea;

/**
 *
 * @author njdbi
 */
public class TextComponentHandler extends Handler {
     private final JTextArea text;
    TextComponentHandler(JTextArea text) {
      this.text = text;
    }
  @Override
  public void publish(LogRecord lr) {
    if (isLoggable(lr))
      synchronized(text) {
        text.append(getFormatter().format(lr));
      }
  }
  @Override
  public void flush() {/**/}
  @Override
  public void close() throws SecurityException {/**/}

}
