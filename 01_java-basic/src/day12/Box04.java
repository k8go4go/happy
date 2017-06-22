/*
 *   T : Type
 *   E : Element
 *   K : Key
 *   V : Value
 *   N : Number
 */
package day12;

public class Box04<K, V> {
	private K key;
	private V value;
	public Box04(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
