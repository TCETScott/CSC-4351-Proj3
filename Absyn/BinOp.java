package Absyn;
import Symbol.Symbol;
public class BinOp extends Exp {
   public Exp left, right;
   public int oper;
   public BinOp(int p, Exp l, int o, Exp r) {pos=p; left=l; oper=o; right=r;}
   public final static int LOGICAL_OR=0, LOGICAL_AND=1, INCLUSIVE_OR=2, EXCLUSIVE_OR=3,
      AND=4, EQ=5, NE=6, LT=7, GT=8, LE=9, GE=10, LEFT_SHIFT=11, RIGHT_SHIFT=12,
      PLUS=13, MINUS=14, MUL=15, DIV=16, MOD=17, ASSIGN=18;
}
