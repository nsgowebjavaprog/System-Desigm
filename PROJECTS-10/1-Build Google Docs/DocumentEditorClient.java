
// Required imports
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

// ===================== INTERFACES AND ELEMENT CLASSES =====================

// Interface representing a generic document element
interface DocumentElement {
    public abstract String render(); // Method to return element as string
}

// TextElement represents plain text in the document
class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    // Render the text content
    @Override
    public String render() {
        return text;
    }
}

// ImageElement represents an image in the document
class ImageElement implements DocumentElement {
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    // Render a placeholder for the image path
    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

// NewLineElement inserts a line break in the document
class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

// TabSpaceElement inserts a tab character in the document
class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

// ===================== DOCUMENT CLASS =====================

// Document class holds and manages a list of document elements
class Document {
    private List<DocumentElement> documentElements = new ArrayList<>();

    // Add an element (text, image, newline, tab) to the document
    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    // Render the entire document by combining all elements' string representations
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}

// ===================== PERSISTENCE INTERFACES =====================

// Interface representing a storage mechanism
interface Persistence {
    void save(String data);
}

// FileStorage saves document content to a file
class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try {
            FileWriter outFile = new FileWriter("document.txt"); // Write to file
            outFile.write(data); // Write content
            outFile.close(); // Close file
            System.out.println("Document saved to document.txt"); // Notify user
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

// DBStorage would represent saving to a database (placeholder here)
class DBStorage implements Persistence {
    @Override
    public void save(String data) {
        // Future implementation for database storage
    }
}

// ===================== DOCUMENT EDITOR =====================

// DocumentEditor provides methods to build and manage a document
class DocumentEditor {
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    // Adds a text element to the document
    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    // Adds an image element to the document
    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    // Adds a newline element to the document
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    // Adds a tab space to the document
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    // Renders the full document as a string (caches result for reuse)
    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    // Saves the rendered document using the specified storage
    public void saveDocument() {
        storage.save(renderDocument());
    }
}

// ===================== CLIENT USAGE =====================

public class DocumentEditorClient {
    public static void main(String[] args) {
        // Create a new Document and a File-based storage implementation
        Document document = new Document();
        Persistence persistence = new FileStorage();

        // Create a DocumentEditor with the document and storage backend
        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Add content to the document (text, newlines, tabs, and images)
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render the document and print it to the console
        System.out.println(editor.renderDocument());

        // Save the document to a file
        editor.saveDocument();
    }
}


// | Section                                   | Purpose                                                   |
// | ----------------------------------------- | --------------------------------------------------------- |
// | `DocumentElement` Interface               | Common interface for all document parts.                  |
// | `TextElement`, `ImageElement`, etc.       | Concrete implementations of document parts.               |
// | `Document` class                          | Holds and renders the complete document.                  |
// | `Persistence`, `FileStorage`, `DBStorage` | Abstract and concrete mechanisms to save data.            |
// | `DocumentEditor`                          | High-level interface for clients to manipulate documents. |
// | `DocumentEditorClient`                    | Main method demonstrating usage.                          |