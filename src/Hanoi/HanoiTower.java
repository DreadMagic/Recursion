package Hanoi;

public class HanoiTower {
    private Peg peg1;
    private Peg peg2;
    private Peg peg3;
    private int numDiscs;

    public HanoiTower(int num)
    {
        peg1 = new Peg(1,num);
        for( int i = num; i > 0; i--) peg1.addDisc(i);
        peg2 = new Peg(2,num);
        peg3 = new Peg(3,num);
        numDiscs=num;

    }
    public void solveTower()
    {

        moveTower(peg1, peg3, peg2, numDiscs);
    }

    private void moveTower(Peg startPeg, Peg endPeg, Peg extraPeg, int numtoMove)
    {
        // TODO move discs(number input) from the start peg to the end peg
        if(numtoMove<0) return;
        if(numtoMove==0){
            startPeg.moveTopDisc(extraPeg);
            return;
        }
        if(numtoMove == 1) {
            startPeg.moveTopDisc(endPeg);
            return;
        }
        moveTower(startPeg, extraPeg, endPeg, numtoMove-1);
        startPeg.moveTopDisc(endPeg);
//        extraPeg.moveTopDisc(endPeg);
        moveTower(extraPeg,endPeg,startPeg, numtoMove -1);
    }
    public static void main(String[] args) {
//        // TODO Auto-generated method stub
        HanoiTower ht = new HanoiTower(5);
        ht.solveTower();
//        HanoiTower h = new HanoiTower(2);
//        h.peg1.moveTopDisc(h.peg2);
//        h.peg1.moveTopDisc(h.peg3);
//        h.peg2.moveTopDisc(h.peg3);
//        System.out.println(h.peg3);
    }

}
