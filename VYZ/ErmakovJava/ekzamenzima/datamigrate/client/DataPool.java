package VYZ.ErmakovJava.ekzamenzima.datamigrate.client;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline.ExecuteException;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline.ProcedureInterface;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline.inputlistener.InputListener;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.ParserInterface;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.exception.ParseException;

public class DataPool<T,S> {
    private List<ProcedureInterface<T>> procedures = new ArrayList<>();
    public DataPool() {}

    public void start(InputListener<S> inputListener, ParserInterface<T,S> parser) {
        try{
            while (true) {// гет дата
                S item = inputListener.run();
                try {
                    T parsedItem = parser.parse(item);
                    for (ProcedureInterface<T> procedure : procedures) {
                    parsedItem = procedure.execute(parsedItem);   /// тут как обычно очень много туда сюда и спорно но я ничего не знаю я глупенький и то и се и фильтр и редюсе и то и се ештваи клеш просто
                    }
                    
                } catch (ParseException e) {
                    System.err.println("Failed to parse line: " + e.getMessage());
                }catch (ExecuteException e) {
                    System.err.println("Failed to execute procedure: " + e.getMessage());
                }
                catch (Exception e) {
                    System.err.println("Unexpected error: " + e.getMessage());
                }finally {
                    if (inputListener.isClosed()) {
                        break;
                    }
                }
            }
        } finally {
            inputListener.close();
        }
    }
    
    public void addProcedure(ProcedureInterface<T> procedure) {
        this.procedures.add(procedure);
    }
}
