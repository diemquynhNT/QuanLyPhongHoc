package CalendarForm;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Timer;

public class PanelSlide extends javax.swing.JPanel {
    private final Timer timer; //hiệu ứng trượt qua lại
    //Các thành phần ở giao diện được hiển thị và ẩn trong lúc trượt
    private Component comExit;
    private Component comShow;
    private AnimateType animateType; //huong di chuyen
    private int animate = 100;// toc do
    public int getAnimate() {
        return animate;
    }

    public void setAnimate(int animate) {
        this.animate = animate;
    }

    public PanelSlide() {
        initComponents();
        setLayout(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                comShow.setSize(getSize());
            }

        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });

    }


    public void show(Component com, AnimateType animateType) {
        if (!timer.isRunning()) {
            this.animateType = animateType;
            this.comShow = com;
            com.setSize(getSize());
            if (getComponentCount() == 0) {
                add(com);
                comExit = com;
                repaint();
                revalidate();
            } else {

                if (animateType == AnimateType.TO_RIGHT) {
                    comShow.setLocation(-comShow.getWidth(), 0);
                } else {
                    comShow.setLocation(getWidth(), 0);
                }
                add(com);
                repaint();
                revalidate();
                timer.start();

            }
        }
    }

    private void animate() {
        if (animateType == AnimateType.TO_RIGHT) {
            if (comShow.getLocation().x < 0) {
                comShow.setLocation(comShow.getLocation().x + animate, 0);
                comExit.setLocation(comExit.getLocation().x + animate, 0);
            } else {
                //  Stop animate
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        } else {
            if (comShow.getLocation().x > 0) {
                comShow.setLocation(comShow.getLocation().x - animate, 0);
                comExit.setLocation(comExit.getLocation().x - animate, 0);
            } else {
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static enum AnimateType {
        TO_RIGHT, TO_LEFT
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
