package me.amitshekhar.image.loading.issues.lrucache

fun main() {
    val cache = LRUCache(3)
    cache.put(1, 10)
    cache.put(2, 20)
    cache.put(3, 30)
    println("*******************************************")
    println("GET value for the key = 2 : ${cache.get(2)}")
    println("*******************************************")
    cache.put(4, 40)
    cache.put(5, 50)
}

private class Node(
    val key: Int,
    var value: Int,
    var next: Node? = null,
    var prev: Node? = null
)

class LRUCache(private val capacity: Int) {

    private val head = Node(0, 0)
    private val tail = Node(0, 0)
    private val hashMap = HashMap<Int, Node>()

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (key !in hashMap) return -1
        val nodeToBeRemoved = hashMap.getValue(key)
        removeNode(nodeToBeRemoved)
        insertAtEnd(nodeToBeRemoved)
        return nodeToBeRemoved.value
    }

    fun put(key: Int, value: Int) {
        if (key in hashMap) {
            val nodeToBeMoved = hashMap.getValue(key)
            nodeToBeMoved.value = value
            removeNode(nodeToBeMoved)
            insertAtEnd(nodeToBeMoved)
            return
        }
        if (hashMap.size == capacity) {
            val nodeToRemove = head.next!!
            removeNode(nodeToRemove)
            hashMap.remove(nodeToRemove.key)
        }
        val newNode = Node(key, value)
        insertAtEnd(newNode)
        hashMap[key] = newNode
        printHashMap(key, value)
    }

    private fun insertAtEnd(node: Node) {
        node.prev = tail.prev
        node.next = tail
        tail.prev!!.next = node
        tail.prev = node
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun printHashMap(key: Int, value: Int) {
        println("-------------------------------------------")
        println("After adding key = $key and value = $value")
        println("Current Status of hashMap")
        hashMap.forEach {
            println("key = ${it.key} and value = ${it.value.value}")
        }
        println("-------------------------------------------")
    }

}