package video.aplication;

import video.persistence.Repository;
import video.utilities.EstadoVideo;


public class ProcesoCargaVideo {
	
	public void cargar(int elementoLista) {
		
		Repository repository = Repository.getInstance();
		System.out.println(repository.getVideos().size());
		int time = 0;
		while(time <= 10) {
			if(time < 5) {
				repository.getVideos().get(elementoLista).setEstado(EstadoVideo.UPLOADING);
				System.out.println(repository.getVideos().get(elementoLista).getEstado() + "..");
			}else if(time < 10) {
				repository.getVideos().get(elementoLista).setEstado(EstadoVideo.VERIFYING);
				System.out.println(repository.getVideos().get(elementoLista).getEstado() + "..");
			}else {
				repository.getVideos().get(elementoLista).setEstado(EstadoVideo.PUBLIC);
				System.out.println(repository.getVideos().get(elementoLista).getEstado());
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			time++;
		}
		
	}

}
