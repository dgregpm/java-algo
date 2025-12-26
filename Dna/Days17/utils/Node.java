package utils;

public class Node<T> {
  private T data;
  public Node<T> next;

  public Node(T data){
    this.data = data;
    this.next = null;
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
