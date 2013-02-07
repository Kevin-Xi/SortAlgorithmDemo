JAVAC = javac
JAVA = java
.SUFFIXES : .class .java

.java.class :
	$(JAVAC) $<

engine/SortAlgorithmDemo.class : engine/SortAlgorithmDemo.java engine/Driving.class gui/*.class algorithm/*.class
engine/Driving.class : engine/Driving.java
algorithm/BubbleSort.class : algorithm/BubbleSort.java
algorithm/HeapSort.class : algorithm/HeapSort.java
algorithm/InsertionSort.class : algorithm/InsertionSort.java
algorithm/QuickSort.class : algorithm/QuickSort.java
algorithm/SelectionSort.class : algorithm/SelectionSort.java
algorithm/ShellSort.class : algorithm/ShellSort.java
gui/Column.class : gui/Column.java
gui/DemoFrame.class : gui/DemoFrame.java
gui/SettingFrame.class : gui/SettingFrame.java

run :
	$(JAVA) engine.SortAlgorithmDemo	
