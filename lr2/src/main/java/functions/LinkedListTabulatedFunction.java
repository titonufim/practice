package functions;

import java.util.Objects;
public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
      static class Node {
        public double x;
        public double y;
        public Node next;
        public Node prev;

        Node(double x, double y) {
            this.x = x;
            this.y = y;
            this.next = null;
            this.prev = null;
        }


        public String toString() {
            return "(" + x + "; " + y + ")";
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Double.compare(x, node.x) == 0 && Double.compare(y, node.y) == 0 && Objects.equals(next, node.next) && Objects.equals(prev, node.prev);
        }

        public int hashCode() {
            int result = 31 * Double.hashCode(x);
            result = 31 * result + Double.hashCode(y);
            return result;
        }

        public Object clone() {
            Node cloneNode = new Node(x, y);
            cloneNode.prev = this.prev;
            cloneNode.next = this.next;
            return cloneNode;
        }
    }

    private int count;
    private Node head;

    private void addNode(double x, double y) {
        Node newNode = new Node(x, y);
        if (count == 0) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
        count++;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < xValues.length; i++) {
            addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        if (xFrom == xTo) {
            double y = source.apply(xFrom);
            for (int i = 0; i < count; i++) {
                addNode(xFrom, y);
            }
        } else {
            double step = (xTo - xFrom) / (count - 1);
            for (int i = 0; i < count; i++) {
                double x = xFrom + i * step;
                double y = source.apply(x);
                addNode(x, y);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public double leftBound() {
        return head.x;
    }

    public double rightBound() {
        return head.prev.x;
    }

    private Node getNode(int index) {
        Node currentNode;
        if (index < count / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = head.prev;
            for (int i = count - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }


    public double getX(int index) {
        return getNode(index).x;
    }

    public double getY(int index) {
        return getNode(index).y;
    }

    public void setY(int index, double value) {
        getNode(index).y = value;
    }

    public int indexOfX(double x) {
        Node currentNode = head;
        for (int i = 0; i < count; i++) {
            if (currentNode.x == x) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public int indexOfY(double y) {
        Node currentNode = head;
        for (int i = 0; i < count; i++) {
            if (currentNode.y == y) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    protected int floorIndexOfX(double x) {
        if (x < head.x) {
            return -1;
        }
        Node currentNode = head;
        for (int i = 0; i < count; i++) {
            if (x >= currentNode.x && x <= currentNode.next.x) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return count - 1;
    }

    protected double extrapolateLeft(double x) {
        double x0 = head.x;
        double x1 = head.next.x;
        double y0 = head.y;
        double y1 = head.next.y;
        return interpolate(x, x0, x1, y0, y1);
    }

    protected double extrapolateRight(double x) {
        double x0 = head.prev.x;
        double x1 = head.x;
        double y0 = head.prev.y;
        double y1 = head.y;
        return interpolate(x, x0, x1, y0, y1);
    }

    protected double interpolate(double x, int floorIndex) {
        Node node = getNode(floorIndex);
        double x0 = node.x;
        double x1 = node.next.x;
        double y0 = node.y;
        double y1 = node.next.y;
        return interpolate(x, x0, x1, y0, y1);
    }

    public String toString() {
        String result = "";
        Node currentNode = head;
        for (int i = 0; i < count; i++) {
            result += currentNode.toString();
            if (i < count - 1) {
                result += ", ";
            }
            currentNode = currentNode.next;
        }
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListTabulatedFunction that = (LinkedListTabulatedFunction) o;
        if (count != that.count) return false;
        for (int i = 0; i < count; i++) {
            if (getX(i) != that.getX(i) || getY(i) != that.getY(i)) {
                return false;

            }
        }
        return true;
    }
    public Object clone() {
        double[] clonedXValues = new double[count];
        double[] clonedYValues = new double[count];
        for (int i = 0; i < count; i++) {
            clonedXValues[i] = getX(i);
            clonedYValues[i] = getY(i);
        }
        return new LinkedListTabulatedFunction(clonedXValues, clonedYValues);
    }
    public int hashCode() {
        int result = 1;
        Node currentNode = head;
        for (int i = 0; i < count; i++) {
            result = 31 * result + currentNode.hashCode();
            currentNode = currentNode.next;
        }
        return result;
    }

}
