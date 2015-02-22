package com.brest.ericpol;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class FullReport {

    private List<MyBean> list = null;

    private boolean tankNumber;
    private boolean tankModification;
    private boolean tankPrice;
    private boolean equipmentModification;
    private boolean equipmentPrice;
    private int amountOfTrueFlags;

    public FullReport(boolean tankNumber, boolean tankModification, boolean tankPrice,
                      boolean equipmentModification, boolean equipmentPrice, List<MyBean> list) {
        this.list = list;
        this.tankNumber = tankNumber;
        this.tankModification = tankModification;
        this.tankPrice = tankPrice;
        this.equipmentModification = equipmentModification;
        this.equipmentPrice = equipmentPrice;

        if(isTrue(tankNumber)){
            amountOfTrueFlags++;
        }

        if(isTrue(tankModification)){
            amountOfTrueFlags++;
        }

        if(isTrue(tankPrice)){
            amountOfTrueFlags++;
        }

        if(isTrue(equipmentModification)){
            amountOfTrueFlags++;
        }

        if(isTrue(equipmentPrice)){
            amountOfTrueFlags++;
        }

        if(amountOfTrueFlags > 0) {
            build();
        }
    }

    private void build() {
        SubreportBuilder subreport = cmp.subreport(new SubreportExpression())
                .setDataSource(new SubreportDataSourceExpression());



        try {
            report()
                    .title(Templates.createTitleComponent("Tank report"))
                    .detail(
                            subreport,
                            cmp.verticalGap(20))
                   // .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .toPdf(new FileOutputStream("/home/simpson/report.pdf"));

        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        return new JREmptyDataSource(list.size());
    }

    private class SubreportExpression extends AbstractSimpleExpression<JasperReportBuilder> {
        private static final long serialVersionUID = 1L;

        @Override
        public JasperReportBuilder evaluate(ReportParameters reportParameters) {
            int masterRowNumber = reportParameters.getReportRowNumber() - 1;
            System.out.println(masterRowNumber);
            JasperReportBuilder report = report();
            report
                    .setTemplate(Templates.reportTemplate);

            if(isTrue(tankNumber)){
                report.addColumn(col.column("Tank Number", "tankNumber", type.stringType()));
            }

            if(isTrue(tankModification)){
                report.addColumn(col.column("Tank Modification", "tankMod", type.stringType()));
            }

            if(isTrue(tankPrice)){
                report.addColumn(col.column("Tank Price", "tankPrice", type.longType()));
            }

            if(isTrue(equipmentModification)){
                report.addColumn(col.column("Equipment Modification", "eqMod", type.stringType()));
            }

            if(isTrue(equipmentPrice)){
                report.addColumn(col.column("Equipment Price", "eqPrice", type.longType()));
            }

            return report;
        }
    }

    private class SubreportDataSourceExpression extends AbstractSimpleExpression<JRDataSource> {
        private static final long serialVersionUID = 1L;

        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            int masterRowNumber = reportParameters.getReportRowNumber() - 1;
            String[] columns = new String[amountOfTrueFlags];//{"tankNumber", "tankMod", "tankPrice", "eqMod", "eqPrice"};
            int indexCounter = 0;
            if(isTrue(tankNumber)){
                columns[0] = "tankNumber";
                indexCounter++;
            }

            if(isTrue(tankModification)){
                columns[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = "tankMod";
                indexCounter++;
            }

            if(isTrue(tankPrice)){
                columns[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = "tankPrice";
                indexCounter++;
            }

            if(isTrue(equipmentModification)){
                columns[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = "eqMod";
                indexCounter++;
            }

            if(isTrue(equipmentPrice)){
                columns[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = "eqPrice";
                indexCounter++;
            }

            Integer eqSize = list.get(masterRowNumber).getTankEquipment().size();
            DRDataSource dataSource = new DRDataSource(columns);


            for(int i = 0; i < eqSize; i++) {
                Object[] values = new Object[amountOfTrueFlags];
                indexCounter = 0;

                if(i == 0) {
                    if(isTrue(tankNumber)){
                        System.out.println(isTrue(tankNumber) + " " + indexCounter);
                        System.out.println("DS tankNumber " + indexCounter);
                        values[0] = list.get(masterRowNumber).getTankNumber();
                        indexCounter++;
                    }

                    if(isTrue(tankModification)){
                        System.out.println("DS tmod" + indexCounter);
                        values[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = list.get(masterRowNumber).getTankModification();
                        indexCounter++;
                    }

                    if(isTrue(tankPrice)){
                        System.out.println("tp " + indexCounter);
                        values[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = list.get(masterRowNumber).getTankPrice();
                        indexCounter++;
                    }

                } else{
                    if(isTrue(tankNumber)){
                        indexCounter++;
                    }

                    if(isTrue(tankModification)){
                        indexCounter++;
                    }

                    if(isTrue(tankPrice)){
                        indexCounter++;
                    }
                }

                if(isTrue(equipmentModification)){
                    System.out.println("em " + indexCounter);
                    values[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = list.get(masterRowNumber).getTankEquipment().get(i).getModification();
                    indexCounter++;
                }

                if(isTrue(equipmentPrice)){
                    System.out.println("ep " + indexCounter);
                    values[amountOfTrueFlags - (amountOfTrueFlags - indexCounter)] = list.get(masterRowNumber).getTankEquipment().get(i).getPrice();
                    indexCounter++;
                }

                dataSource.add(values);
            }

            return dataSource;
        }
    }

    public static void main(String [] argc){
     //   new FullReport().build();
    }

}

