package utils;

public class Node<T> {
  private T data;
  public Node<T> prev;
  public Node<T> next;
  public Node<T> left;
  public Node<T> right;

  public Node(T data){
      this.data = data;
      this.prev = this.next = this.left = this.right = null;
  }
  public T getData(){
    return this.data;
  }

  public void setData(T obj){
    this.data = obj;
  }

  @Override
  public String toString(){
    return this.data.toString();
  }
}
