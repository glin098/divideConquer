public interface IPerson extends Comparable<IPerson> {

	public int getId();
	public String getFirstName();
	public String getLastName();
	@Override
	public String toString();
	@Override
	public int compareTo(IPerson p);

}

