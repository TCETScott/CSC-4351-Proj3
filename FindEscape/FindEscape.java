package FindEscape;

public class FindEscape {
  Symbol.Table escEnv = new Symbol.Table(); // escEnv maps Symbol to Escape

  public FindEscape(Absyn.Exp e) { traverseExp(0, e);  }

  void traverseVar(int depth, Absyn.Var v) {
  }

  void traverseExp(int depth, Absyn.Exp e) {
  }

  void traverseDec(int depth, Absyn.Dec d) {
    if (d instanceof VarDec) {
      VarDec var = (VarDec)d;
      escEnv.put(var.name, new EscapeEntry(depth, false));
      traverseExp(depth, var.init);
    } 
    else if (d instanceof FunDec) {
      FunDec fun = (FunDec)d;
      escEnv.beginScope();
      for (FieldList params = fun.params; params != null; params = params.tail)
        escEnv.put(params.head.name, new EscapeEntry(depth + 1, false));
      traverseExp(depth + 1, fun.body);
      escEnv.endScope();
    }
  }
}
