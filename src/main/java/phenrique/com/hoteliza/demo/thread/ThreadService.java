package phenrique.com.hoteliza.demo.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import phenrique.com.hoteliza.demo.repository.RoomRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;




@Service
public class ThreadService {

   

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Autowired
    private RoomRepository roomRepository;

    private Long totalRooms = 0L;

    @PostConstruct
    public void startThread() {
        executorService.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                  
                    totalRooms = roomRepository.count(); 

                    System.out.println("Total de quartos: " + totalRooms);

                    TimeUnit.SECONDS.sleep(5); 

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrompida, encerrando...");
                    break;

                }
            }
        });
    }

    public Long getTotalRooms() {
        return totalRooms;
    }

    @PreDestroy
    public void shutdown() {

        System.out.println("Encerrando serviço de threads...");

        executorService.shutdown();

        try {

            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {

                System.err.println("Forçando encerramento das tarefas...");

                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {

            System.err.println("Erro ao aguardar encerramento do executor: " + e.getMessage());

            executorService.shutdownNow();

            Thread.currentThread().interrupt();

        }
    }
}

