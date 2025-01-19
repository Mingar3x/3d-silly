import java.util.HashMap;
import java.util.Map;
//the whole point of this class is to store vertices so
//they can be shared within continous masses, saving memory
public class VertexPool {
    //THIS DOES NOT WORK FOR VERTICES THAT MOVE IN WORLD SPACE
    //NEED TO FIND WORKAROUND LATER
    //this is a hashmap that stores vertices, and each vertex uses its location as a key
    public Map<Vector3, Vector3> sharedVertices = new HashMap<>();

    // Retrieve or create a shared vertex
    public Vector3 getSharedVertex(Vector3 LocationKey) {
        // If the vertex exists, return it
        if (sharedVertices.containsKey(LocationKey)) {
            return sharedVertices.get(LocationKey);
        }
        Vector3 newVertex = LocationKey;
        sharedVertices.put(LocationKey, newVertex);
        return newVertex;
    }

    //clearing later it will save memory or something
    public void clear() {
        sharedVertices.clear();
    }
}
