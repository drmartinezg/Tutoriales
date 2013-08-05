package es.duero4.tddinactionjee.web.view.jsp.velocity;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.w3c.dom.Document;

/**
 *
 * @author Ramon
 */
public abstract class VelocityTestCase {
    
    private VelocityContext context;
    protected Document document;
    
    @Before
    public void setUp() {
        // 1. Fresh context for each test
        context = new VelocityContext();
    }
    
    protected String getWebRoot() {
        return ".";
    }
    
    protected void setAttribute(String name, Object value) {
        // 2. Test need to populate attributes to VelocityContext
        context.put(name, value);
    }
    
    protected void render(String templatePath) throws Exception {
        File templateFile = new File(getWebRoot(), templatePath);
        String template = readFileContent(templateFile);
        // 3. Render template in memory
        String renderedHtml = renderTemplate(template);
        // 4. Parse rendered HTML into DOM tree
        this.document = parseAsXml(renderedHtml);
    }

    private String readFileContent(File file) throws Exception {
        FileReader reader = new FileReader(file);
        StringWriter writer = new StringWriter();
        char[] buffer = new char[8096];
        int r = -1;
        while ( (r = reader.read(buffer)) != -1 ) {            
            writer.write(buffer, 0, r);
        }
        reader.close();
        return String.valueOf(writer);
        
    }

    private String renderTemplate(String template) {
        VelocityEngine engine = new VelocityEngine();
        engine.init();
        StringWriter writer = new StringWriter();
        engine.evaluate(context, writer, "test", template);
        return writer.toString();
    }

    private Document parseAsXml(String xml) throws Exception {
        DocumentBuilder b = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return b.parse(new ByteArrayInputStream(xml.getBytes()));
        
    }
}
