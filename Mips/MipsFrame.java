package Mips;
import java.util.Hashtable;
import Symbol.Symbol;
import Temp.Temp;
import Temp.Label;
import Frame.Frame;
import Frame.Access;
import Frame.AccessList;

public class MipsFrame extends Frame {

  private int count = 0;
  public Frame newFrame(Symbol name, Util.BoolList formals) {
    Label label;
    if (name == null)
      label = new Label();
    else if (this.name != null)
      label = new Label(this.name + "." + name + "." + count++);
    else
      label = new Label(name);
    return new MipsFrame(label, formals);
  }

  public MipsFrame() {}
  private MipsFrame(Label n, Util.BoolList f) {
    name = n;
    AccessList head = null;
    AccessList tail = null;
    while (f != null) {
      Access acc;
      if (f.head)
        acc = new InFrame(formalCount * wordSize);
      else
        acc = new InReg(new Temp());
      if (head == null)
        head = tail = new AccessList(acc, null);
      else
        tail = tail.tail = new AccessList(acc, null);
      formalCount++;
      f = f.tail;
      }
    formals = head;
  }

  private static final int wordSize = 4;
  public int wordSize() { return wordSize; }

  public Access allocLocal(boolean escape) { 
    if (escape) {
      localCount++;
      return new InFrame(-localCount * wordSize);
    }
    else {
      return new InReg(new Temp());
    }
  }
}
