package com.brest.ericpol.blog;

import com.brest.ericpol.blog.service.model.BlogEntry;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * Created by simpson on 09/03/15.
 */
public class ReportCreator {

    private List<BlogEntry> list;
    private String fileName;
    private String fileType;
    private String userName;

    public ReportCreator(String fileType, String fileName, List<BlogEntry> list, String userName){
        this.list = list;
        this.fileName = fileName;
        this.fileType = fileType;
        this.userName = userName;

        build();
    }

    private void build() {
        TextColumnBuilder<Long> entryIdColumn = col.column("EntryId", "entryId", type.longType());
        TextColumnBuilder<String> titleColumn = col.column("Title", "title", type.stringType());
        TextColumnBuilder<String> contentColumn = col.column("Message", "entryText", type.stringType()).setStyle(stl.style().setHorizontalAlignment(HorizontalAlignment.LEFT)
                .setMarkup(Markup.HTML));
        TextColumnBuilder<Date> dateColumn = col.column("Date", "entryDate", type.dateType());

        try {
                   // report().toPdf(new FileOutputStream("/home/simpson/report3.pdf"));
            if (fileType.equals("PDF")) {
                report().setTemplate(Templates.reportTemplate)
                        .columns(entryIdColumn, titleColumn, contentColumn, dateColumn)
                        .title(Templates.createTitleComponent(userName))
                        .sortBy(asc(entryIdColumn))
                        .setDataSource((createDataSource()))
                        .toPdf(new FileOutputStream("/home/simpson/" + fileName + ".pdf"));
            } else if (fileType.equals("XLS")) {
                report().setTemplate(Templates.reportTemplate)
                        .columns(entryIdColumn, titleColumn, contentColumn, dateColumn)
                        .title(Templates.createTitleComponent(userName))
                        .sortBy(asc(entryIdColumn))
                        .setDataSource((createDataSource()))
                        .toXlsx(new FileOutputStream("/home/simpson/" + fileName + ".xls"));
            } else if (fileType.equals("PDF and XLS")) {
                report().setTemplate(Templates.reportTemplate)
                        .columns(entryIdColumn, titleColumn, contentColumn, dateColumn)
                        .title(Templates.createTitleComponent(userName))
                        .sortBy(asc(entryIdColumn))
                        .setDataSource((createDataSource()))
                        .toXlsx(new FileOutputStream("/home/simpson/" + fileName + ".xls"))
                        .toPdf(new FileOutputStream("/home/simpson/" + fileName + ".pdf"));
            }
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        private JRDataSource createDataSource(){
            DRDataSource dataSource = new DRDataSource("entryId", "title", "entryText", "entryDate");

            for (BlogEntry be : list) {
                dataSource.add(be.getEntryId(), be.getTitle(), be.getEntryText(), be.getEntryDate());
            }

            return dataSource;
        }
    }