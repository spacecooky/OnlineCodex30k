package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class NEExtinktoren extends Eintrag {

	AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkTransport;
    boolean isPyrrhianer = false;

	public NEExtinktoren() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Extinktoren", 5, 10, 17);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEExtinktoren.jpg"));

		seperator();
        
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pyrrhianische Ewige", "Upgrade zu Pyrrhianischen Ewigen", 0));
        oe1.setAktiv(false);
        
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Gauss-Blaster", 0));
		ogE.addElement(new OptionsGruppeEintrag("Tesla-Karabiner", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();;

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NETransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        
        int anrakyr = BuildaHQ.getCountFromInformationVector("NEAnrakyrderReisende");
        int pyrrhianer = BuildaHQ.getCountFromInformationVector("NEPyrrhianer");
        if(anrakyr > 0 && pyrrhianer == 0) {
            BuildaHQ.addToInformationVector("NEPyrrhianer", 1);
            isPyrrhianer = true;
        }
        
        if(anrakyr == 0) {
            if(isPyrrhianer) BuildaHQ.addToInformationVector("NEPyrrhianer", -1);
            isPyrrhianer = false;
        }
        
        oe1.setAktiv(isPyrrhianer);
        oe1.setSelected(isPyrrhianer);            
	}
    
	@Override
	public void deleteYourself() {
		super.deleteYourself();
        if(oe1.isSelected()) {
            BuildaHQ.addToInformationVector("NEPyrrhianer", -1);
        }
	}

}
