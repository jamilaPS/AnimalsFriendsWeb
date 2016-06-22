package testeDao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.GenericDAO;
import modelo.MausTratos;

public class TesteJUnit {

	@Test
	public void testeInserir(){
		GenericDAO dao = new GenericDAO();
		MausTratos mausTratos = new MausTratos();
		mausTratos.setCidade("Paranavaí");
		mausTratos.setDescricao("Atiraram o pau no gato.");
		mausTratos.setLatitude("-23.83918");
		mausTratos.setLongitude("-52.765432");
		mausTratos.setTelefone("98987070");
		
		dao.inserir(mausTratos);
		
		MausTratos resultado = null;
		List<MausTratos> listaMausTratos = dao.buscarTodos(MausTratos.class);
		for(MausTratos mt : listaMausTratos){
			if(mt.getDescricao().equals(mausTratos.getDescricao())
				&& mt.getCidade().equals(mausTratos.getCidade())
				&& mt.getLatitude().equals(mausTratos.getLatitude())
				&& mt.getLongitude().equals(mausTratos.getLongitude())
				&& mt.getTelefone().equals(mausTratos.getTelefone())){
				resultado = mt;
				break;
			}
		}
		
		Assert.assertEquals(mausTratos, resultado);
	}
	
	@Test
	public void testeAlterar(){
		GenericDAO dao = new GenericDAO();
		MausTratos mausTratos = new MausTratos();
		mausTratos.setCidade("Paranavaí");
		mausTratos.setDescricao("Mas o gato não morreu.");
		mausTratos.setLatitude("-23.83918");
		mausTratos.setLongitude("-52.765432");
		mausTratos.setTelefone("98987070");
		
		dao.inserir(mausTratos);
		
		mausTratos.setCidade("Maringá");
		dao.alterar(mausTratos);
		
		MausTratos resultado = null;
		List<MausTratos> listaMausTratos = dao.buscarTodos(MausTratos.class);
		for(MausTratos mt : listaMausTratos){
			if(mt.getDescricao().equals(mausTratos.getDescricao())
				&& mt.getCidade().equals(mausTratos.getCidade())
				&& mt.getLatitude().equals(mausTratos.getLatitude())
				&& mt.getLongitude().equals(mausTratos.getLongitude())
				&& mt.getTelefone().equals(mausTratos.getTelefone())){
				resultado = mt;
				break;
			}
		}
		Assert.assertNotNull(resultado);
	}
	
	@Test
	public void testeExcluir(){
		GenericDAO dao = new GenericDAO();
		List<MausTratos> listaMausTratos = dao.buscarTodos(MausTratos.class);
		for(MausTratos mt : listaMausTratos){
			dao.excluir(mt);
		}
		List<MausTratos> resultado = dao.buscarTodos(MausTratos.class);
		Assert.assertEquals(0, resultado.size());
	}
	
	@Test
	public void testeRecuperarTodos(){
		GenericDAO dao = new GenericDAO();
		for(int i = 0; i < 5; i++){
			MausTratos mausTratos = new MausTratos();
			mausTratos.setCidade("Paranavaí");
			mausTratos.setDescricao("Atiraram o pau no gato.");
			mausTratos.setLatitude("-23.83918");
			mausTratos.setLongitude("-52.765432");
			mausTratos.setTelefone("9898707"+i);
			
			dao.inserir(mausTratos);
		}
		Integer esperado = 5;
		List<MausTratos> resultado = dao.buscarTodos(MausTratos.class);
		System.out.println(resultado.size());
		Assert.assertEquals(esperado.intValue(), resultado.size());
	}
}
