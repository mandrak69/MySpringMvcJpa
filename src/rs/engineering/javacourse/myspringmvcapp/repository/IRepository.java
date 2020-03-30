package rs.engineering.javacourse.myspringmvcapp.repository;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;




public interface IRepository<T> {
	//kako resiti ako je ID razlicitog tipa, negde string, negde Long, negde slozeni tip
	public T saveOrUpdate(T t);
	public T findById(Long id);
	public List<T> findAll();
	public void delete(T t);
	public void deleteById(Long id);
	public T findByName(T t);
	public List<T> findAllByPredicates(Collection<Predicate<T>> predicates);
}
