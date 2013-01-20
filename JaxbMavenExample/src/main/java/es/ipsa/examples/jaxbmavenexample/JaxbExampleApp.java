package es.ipsa.examples.jaxbmavenexample;

import es.ipsa.examples.jaxbmavenexample.Accounts.Account;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * Clase principal que prueba las clases auto-generadas por el plugin
 * "maven-jaxb-plugin"
 *
 * @author DRMG
 */
public class JaxbExampleApp {

    private static final Logger LOGGER = Logger.getLogger(JaxbExampleApp.class);
    private static final int NUMBER_ACCOUNTS = 5;
    private static final String OUTPUT_FOLDER = System.getProperty("user.home")
            + File.separatorChar + "JaxbExample";

    public static void main(String[] args) {
        JaxbExampleApp main = new JaxbExampleApp();
        try {

            final File accountsFileXml = new File(OUTPUT_FOLDER + File.separatorChar + "accounts.xml");

            main.createOutputDir();
            main.createXmlWithJaxb(accountsFileXml, NUMBER_ACCOUNTS);
            main.readXmlWithJaxb(accountsFileXml);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createOutputDir() throws IllegalStateException {
        File outputDir = new File(OUTPUT_FOLDER);
        if (!outputDir.exists()) {
            LOGGER.info("Creating output folder: " + outputDir.getAbsolutePath());
            if (!outputDir.mkdirs()) {
                throw new IllegalStateException("Could not create "
                        + outputDir.getAbsolutePath());
            }
        }
    }

    private void createXmlWithJaxb(File file, int numberElements) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Accounts.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        Accounts accounts = new ObjectFactory().createAccounts();
        List<Account> accountList = accounts.getAccount();
        for (int i = 0; i < numberElements; i++) {
            Account account = new Account();
            final String sequence = String.format("%02d", i + 1);
            account.setBanco("Banco" + sequence);
            account.setSucursal("Sucursal" + sequence);
            account.setCuenta("Cuenta" + sequence);
            account.setTitutar("Titular" + sequence);
            LOGGER.debug("Creating account <" + account.getBanco() + " - "
                    + account.getSucursal() + " - " + account.getCuenta() + " - "
                    + account.getTitutar() + ">");
            accountList.add(account);
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file), 4096);
        try {
            marshaller.marshal(accounts, bos);
            bos.flush();
        } finally {
            IOUtils.closeQuietly(bos);
        }
    }

    private void readXmlWithJaxb(File accountsFileXml) throws Exception {
        JAXBContext ucontext = JAXBContext.newInstance(Accounts.class);
        Unmarshaller unmarshaller = ucontext.createUnmarshaller();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(accountsFileXml));

        Accounts accounts = (Accounts) unmarshaller.unmarshal(bis);
        List<Account> accountList = accounts.getAccount();
        for (Account account : accountList) {
            LOGGER.info("Reading account <" + account.getBanco() + " - "
                    + account.getSucursal() + " - " + account.getCuenta() + " - "
                    + account.getTitutar() + ">");
        }
    }
}
