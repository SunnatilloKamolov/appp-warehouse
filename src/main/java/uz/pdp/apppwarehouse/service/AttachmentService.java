package uz.pdp.apppwarehouse.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppwarehouse.entity.Attachment;
import uz.pdp.apppwarehouse.entity.AttachmentContent;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.AttachmentContentRepository;
import uz.pdp.apppwarehouse.repository.AttachmentRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment=new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);
        AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("Fayl saqlandi",true,savedAttachment.getId());
    }
    public List<Attachment>getAttachments(){
         return attachmentRepository.findAll();
    }
    public Result deleteAttachment(Integer id){
        attachmentRepository.deleteById(id);
        return new Result("Obyekt o'chirildi",true);
    }
    public Result editAttachment(Attachment attachment,Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()){
            Attachment attachment1 = optionalAttachment.get();
            attachment1.setName(attachment1.getName());
            attachment1.setSize(attachment1.getSize());
            attachment1.setContentType(attachment1.getContentType());
            attachmentRepository.save(attachment1);
            return new Result("Attachment edited",true);
        }return new Result("attachment not found",false);
    }
}
