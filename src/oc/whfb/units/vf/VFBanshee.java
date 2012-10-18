package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class VFBanshee extends Eintrag {
    
        OptionsEinzelUpgrade oGen;
        boolean genSelected = false;

        public VFBanshee() {
                name = BuildaHQ.translate("Banshee");
                grundkosten = 95;

                seperator(12);

                add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));

                complete();
        }

        //@OVERRIDE
        public void refreshen() {

                // Unique entry: GENERAL
                boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );
                if(genGlobal && !genSelected) oGen.setAktiv(false);
                else oGen.setAktiv(true);

                if(oGen.isSelected()) {
                        genSelected = true;
                        BuildaHQ.setInformationVectorValue("Gen", 1);
                } else {
                        if(genSelected) {
                                genSelected = false;
                                BuildaHQ.setInformationVectorValue("Gen", 0);
                                BuildaHQ.refreshEntries(2);
                        }
                }
        }

        @Override
        public void deleteYourself() {
                if(genSelected) {
                        BuildaHQ.setInformationVectorValue("Gen", 0);
                }
                super.deleteYourself();
        }
    }