package teleDemo.entities;

import lombok.Data;

@Data
public class Pair <T,V>{
    T key;
    V value;
    public Pair(T x_, V y_){
        this.key = x_;
        this.value = y_;
    }
    public T getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
}
