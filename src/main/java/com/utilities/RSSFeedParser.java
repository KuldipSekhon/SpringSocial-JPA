package com.utilities;

import com.model.Feed;
import com.model.FeedMessage;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by akhilg on 14/4/14.
 */
public class RSSFeedParser {

    static final String TITLE = "title";
    static final String DESCRIPTION = "description";

    static final Logger logg = Logger.getLogger(RSSFeedParser.class.toString());

    URL url;

    public RSSFeedParser(String feedUrl) {
        try {
            this.url = new URL(feedUrl);
        } catch (MalformedURLException ex) {
            logg.info("URL formed is NOT correct.....");
        }
    }


    public String readFeed() {
   //public Feed readFeed() {
        String description = "";
        String title = "";
        String link = "";

        Feed feed = null;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            InputStream in = read();
            try {
                XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

                while (eventReader.hasNext()) {
                    XMLEvent event = eventReader.nextEvent();

                    if (event.isStartElement()) {
                        String part = event.asStartElement().getName().getLocalPart();
                        /*** QName represents a qualified name as defined in the XML specification */


                        logg.info("Prior to getting the STart Element is RSSFeedParser...");

                        if (part == TITLE) {
                            title = getCharacterData(event, eventReader);
                            return  title;
                        } else if (part == DESCRIPTION) {
                            description = getCharacterData(event, eventReader);
                            return description;
                        } else {

                        }
                    }

                }


            } catch (XMLStreamException ex) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logg.info("Prior to returning from readFeed method from RSSFeedParser..........." + feed.toString());
        return "";
    }

    private InputStream read() {
        try {
            return url.openStream();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {

        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }

        logg.info("Data retreived in method character data is===========" + result);

        return result;

    }
}




/*  Testin
public Feed readFeed() {
    Feed feed = null;
    try {
        boolean isFeedHeader = true;
        // Set header values intial to the empty string
        String description = "";
        String title = "";
        String link = "";
        String language = "";
        String copyright = "";
        String author = "";
        String pubdate = "";
        String guid = "";

        // First create a new XMLInputFactory
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        // Setup a new eventReader
        InputStream in = read();
        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
        // read the XML document
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                String localPart = event.asStartElement().getName()
                        .getLocalPart();
                switch (localPart) {
                    case ITEM:
                        if (isFeedHeader) {
                            isFeedHeader = false;
                            feed = new Feed(title, link, description, language,
                                    copyright, pubdate);
                        }
                        event = eventReader.nextEvent();
                        break;
                    case TITLE:
                        title = getCharacterData(event, eventReader);
                        break;
                    case DESCRIPTION:
                        description = getCharacterData(event, eventReader);
                        break;
                    case LINK:
                        link = getCharacterData(event, eventReader);
                        break;
                    case GUID:
                        guid = getCharacterData(event, eventReader);
                        break;
                    case LANGUAGE:
                        language = getCharacterData(event, eventReader);
                        break;
                    case AUTHOR:
                        author = getCharacterData(event, eventReader);
                        break;
                    case PUB_DATE:
                        pubdate = getCharacterData(event, eventReader);
                        break;
                    case COPYRIGHT:
                        copyright = getCharacterData(event, eventReader);
                        break;
                }
            } else if (event.isEndElement()) {
                if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                    FeedMessage message = new FeedMessage();
                    message.setDescription(description);
                    message.setTitle(title);
                    feed.getMessages().add(message);
                    event = eventReader.nextEvent();
                    continue;
                }
            }
        }
    } catch (XMLStreamException e) {
        throw new RuntimeException(e);
    }
    return feed;
}
}
*/