/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author willi
 */
public class Cell extends JButton{
    
    /*
    Cell conections
    
    ul(0) | up(1) | ur(2)
    ----    ----    ----               The Perimeter
    le(7) | CELL  | ri(3)  >>  ul > up > ur > ri > dr > dw > dl > le
    ----    ----    ----       (0)  (1)  (2)  (3)  (4)  (5)  (6)  (7)
    dl(6) | dw(5) | dr(4)
    */
    
    // Fields
    private Perimeter<Cell> perimeter;
    private Board myBoard;
    /**
     * If cell has a mine hidden
     */
    private boolean mine;
    
    private Marks mark;

    private Point position;
    
    private int number;
    
    // Getters & Setters
    public void setMyBoard(Board current) {
        this.myBoard = current;
    }
    
    /**
     * @return the marcacao
     */
    public Marks getMark() {
        return this.mark;
    }

    /**
     * @param mark
     */
    public void setMark(Marks mark) {
        if (Marks.UNCOVERED == mark) 
            uncoverCell();
        this.mark = mark;
    }    
    
    public void uncoverCell() {
        this.setBorder(null);
    }
    
    /**
     * @return Retorna a posição horizontal
     */
    public int getHPos() {
        return (int) this.position.getX();
    }

    /**
     * @return Retorna a posição vertical
     */
    public int getVPos() {
        return (int) this.position.getY();
    }
    
    // Constructors
    public Cell() {
        this.perimeter = new Perimeter<>();
        this.mine = false;
        this.position = new Point(0,0);
        this.number = 0;
        this.mark = Marks.COVERED;
    }

    public Cell(Point p) {
        this.perimeter = new Perimeter<>();
        this.mine = false;
        this.position = p;
        this.number = 0;
        this.mark = Marks.COVERED;
    }

    public Cell(ArrayList<Cell> perim, boolean mine, Point p) {
        this.perimeter.addAll(perim);
        this.mine = mine;
        this.position = p;
        this.number = 0;
        this.mark = Marks.COVERED;
    }
    
    // Methods
    /**
     * 
     * @return Indica se a célula está vazia e descoberta
     */
    public boolean isEmpty() {
        return (this.number == 0);
    }
    
    public boolean isUncovered() {
        return (this.mark.equals(Marks.UNCOVERED));
    }
    
    public boolean isCovered() {
        return (this.mark.equals(Marks.COVERED));
    }
    
    public boolean isNumbered() {
        return (this.number > 0);
    }
    
    public boolean isMine() {
        return this.mine;
    }

    public boolean isFlagMarked() {
        return (this.mark == Marks.MINEFLAG);
    }
    
    public boolean isDoubtMarked() {
        return (this.mark == Marks.DOUBTFLAG);
    }
    
    public void setMine() {
        this.mine = true;
    }
    
    public void unsetMine() {
        this.mine = false;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public boolean increaseNumber() {
        if (this.number < 9) {
            this.number++;
            return true;
        } 
        else
            return false;
    }
    
    public boolean decreaseNumber() {
        if (this.number > 0) {
            this.number--;
            return true;
        } 
        else
            return false;
    }
    
    public Perimeter<Cell> getPerimeter() {
        return this.perimeter;
    }
    
    public boolean setPerimeter(ArrayList<Cell> perim) {
        return this.perimeter.addAll(perim);
    }
    
    public Cell getCellAtPerimeter(int i) {
        return this.perimeter.get(i);
    }
    
    public boolean increasePerimeterNumbers() {
        return this.perimeter.clearNulls().stream().filter(neighbor -> (!neighbor.isMine())).noneMatch(neighbor -> (!neighbor.increaseNumber()));
    }
    
    /**
     * @return Retorna o ponto configurado.
     */
    public Point getPosition() {
        return this.position;
    }
    
    public int getHowManyMinesAround() {
        int mines = 0;
        
        Perimeter<Cell> sub = this.perimeter.clearNulls();
        
        mines = sub.stream().filter(neighbor -> (neighbor.isMine())).map(_item -> 1).reduce(mines, Integer::sum);
        if (!isMine() && mines != 0) {
            this.setIcon(new ImageIcon(ClassLoader.getSystemResource("resources/"+ String.valueOf(mines)+"raw75.png")));
        } else if (isMine()) {
            this.setIcon(new ImageIcon(ClassLoader.getSystemResource("resources/mine.png")));
        } else {
            revealBlanksNumbers();
        }
        return mines;
    }
    
    /**
     * Revela todas as celulas que estão ao redor da célula revelada, caso
     * a mesma seja vazia. Este método é acionado automaticamente pela célula.
     */
    private void revealBlanksNumbers() {
        perimeter.clearNulls().stream().filter(neighbor -> (neighbor.getMark() == Marks.COVERED && !neighbor.isMine())).forEachOrdered(neighbor -> {
            // Antes de tudo, verificamos se não estamos referenciando a
            // vizinha que nos contatou. Para isso, usamos a mark UNCOVERED,
            // como indicação.
            neighbor.reveal();
        }); 
    }
    
    /**
     * Revela o conteúdo da célula, desde que não esteja marcada
     * @return false termina o jogo, true continua
     */
    public boolean reveal() {
        // Se estiver marcado, não fazemos nada
        if (isFlagMarked()) return true;
        
        // Se for mina, acabou o jogo. A classe board irá mostrar todas as
        // minas e finalizar o jogo.
        if (isMine()) {
            return false;
        }
        
        // Se não for vazia, revela a célula e mostra o número
        if (!isEmpty()) {
            setMark(Marks.UNCOVERED);
            showNumber();
        } 
        // Caso contrário, revela essa e começa a revelar as outras
        // vazias e numéricas próximas
        else {
            setMark(Marks.UNCOVERED);
            revealBlanksNumbers();
        }
        
        // o jogo continua...
        return true;
    }
    
    /**
     * Troca as marcações entre, Bandeira de mina, Dúvidosa ou Coberta
     * @return the last mark
     */
    public Marks toggleMark() {
        switch(this.mark){
            case COVERED:
                setMark(Marks.MINEFLAG);
                showMark(false);
                return Marks.COVERED;
            case MINEFLAG:
                setMark(Marks.DOUBTFLAG);
                showMark(false);
                return Marks.MINEFLAG;
            case DOUBTFLAG:
                setMark(Marks.COVERED);
                showMark(true);
                return Marks.DOUBTFLAG;
            default: return Marks.COVERED;
        }
    }
    
    // Carrega o número da célula
    private void showNumber() {
        String image = "resources/" + String.valueOf(this.number) + "raw75.png";
        this.setIcon(new ImageIcon(ClassLoader.getSystemResource(image)));
    }
    
    /**
     * Carrega a figura de marcação
     * @param remove remove, ao invés
     */
    private void showMark(boolean remove) {
        if (remove) {
            this.setIcon(null);
        } else {
            String image = "resources/" + this.mark.name().toLowerCase() + ".png";
            this.setIcon(new ImageIcon(ClassLoader.getSystemResource(image)));
        }
    }
    
    /**
     * Revela a mina caso seja e não esteja marcada. Mostra a bandeira de mina
     * errada caso não seja mina e esteja marcada.
     */
    public void showMine() {
        if (!isFlagMarked() && isMine()) {
            String image = "resources/mine.png";
            this.setIcon(new ImageIcon(ClassLoader.getSystemResource(image)));
        } else if (isFlagMarked() && !isMine()) {
            String image = "resources/wrongflag.png";
            this.setIcon(new ImageIcon(ClassLoader.getSystemResource(image)));
        }
    }
    
    public void pointMine() {
        List<Cell> unflagged = perimeter.getUnflaggedMines();
        int flagged = perimeter.countFlagged();
        if (number - flagged > 0) {
            unflagged.get(0).toggleMark();
        }
    }
    
    public boolean revealPerimeter() {
        if (number == perimeter.countFlagged()) {
            if (!this.perimeter.clearNulls().stream().noneMatch(neighbor -> (!neighbor.reveal()))) {
                return false;
            }
        }
        return true;
    }
    
    protected enum Marks {
        WRONGFLAG(-1),
        UNCOVERED(0),
        COVERED(1),
        MINEFLAG(2), 
        DOUBTFLAG(3);
        
        private int val;
        
        Marks (int val) {
            this.val = val;
        }
        
        public int getVal() {
            return val;
        }
    }
    
    protected class Perimeter<E> extends ArrayList<E> {

        public Perimeter() {
            super();
        }
        
        public Perimeter(int initialCapacity) {
            super(initialCapacity);
        }
        
        public Perimeter<Cell> clearNulls() {
            Perimeter subPerim = new Perimeter<>(8);
            this.stream().filter(aThi -> (aThi != null)).forEachOrdered(aThi -> {
                subPerim.add(aThi);
            });
            return subPerim;
        }
        
        public ArrayList<Point> getPerimeterPositions() {
            ArrayList positions = new ArrayList<Point>();
            this.clearNulls().stream().forEachOrdered(neighbor -> {
                        positions.add(neighbor.getPosition());
                    });
            return positions;
        }
        
        public Perimeter<Cell> getBlanks() {
            Perimeter blanks = new Perimeter<>();
            this.clearNulls().stream().filter(blank -> (blank.getNumber() == 0)).
                    forEachOrdered(blank -> {
                        blanks.add(blank);
                    });
            return blanks;
        }

        public int countFlagged() {
            final IntCounter counter = new IntCounter();
            this.clearNulls().stream().filter(cell -> (cell.isFlagMarked())).
                    forEachOrdered(cell -> {
                        counter.step();
                    });
            return counter.total();
        }
        
        public int countMarkedBy(Marks mark) {
            final IntCounter counter = new IntCounter();
            this.clearNulls().stream().filter(cell -> (cell.getMark().equals(mark))).
                    forEachOrdered(cell -> {
                        counter.step();
                    });
            return counter.total();
        }
        
        public List<Cell> getUnflaggedMines() {
            return this.clearNulls().stream().filter(neighbor -> neighbor.isMine() && !neighbor.isFlagMarked()).toList();
        }
    }
    
    protected class IntCounter {
        private int count;
        
        IntCounter() {
            count = 0;
        }
        
        public void step() {
            count++;
        }
        
        public int total() {
            return count;
        }
    }
}