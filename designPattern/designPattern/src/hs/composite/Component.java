package hs.composite;
/**
 * �������
 * @author Administrator
 */
public interface Component {
	void operation();
}


/**
 * Ҷ�����
 * @author Administrator
 */
interface Leaf extends Component  {
	
}
/**
 * �������
 * @author Administrator
 */
interface Composite extends Component{
	void add(Component c);
	void Remove(Component c);
	Component getChild(int index);
}