import java.util.ArrayList;


//Render

interface Render{

    public void Render(ArrayList<Element> element);

}

class PDFRender implements Render{

    @Override
    public void Render(ArrayList<Element> element) {
        
    }
    
}

class ScreenRender implements Render{

    @Override
    public void Render(ArrayList<Element> element) {}
    
}


//Elements
interface Element{
    
}


class TextContent implements Element{

    
}

class ImageContent implements Element{

    
}

//Database

interface DataBase{
    public void save(ArrayList<Element> content);

}


class MySql implements DataBase{

    @Override 
    public void save(ArrayList<Element> content){
        //logic
    }

}



//Document
class Document{

    ArrayList<Element> content = new ArrayList<>();
    DataBase db;
    Render pdf = new PDFRender();
    Render screenRender = new ScreenRender();

    public Document(DataBase db){
        this.db=db;
    }

    public void pdfRender(){
        pdf.Render(content);
    }

    public void screenRender(){
        screenRender.Render(content);
    }
    
    public void addElement(Element element){
        content.add(element);
    }

    public void removeElement(Element element){
        //logic
    }

    public void save(){
        db.save(content);
    }

}


