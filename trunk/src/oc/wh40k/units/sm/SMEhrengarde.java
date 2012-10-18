package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMEhrengarde extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
        
        boolean siegeForce;

	public SMEhrengarde() {
		name = "Ehrengarde\n";
		grundkosten = 0;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
                
		BuildaHQ.addToInformationVector("SMHonourGuard", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ehrengardisten", 3, 10, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMEhrengarde.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", "Auxilaris-Granatwerfer", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ordensbanner", 25));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMOrdenschampion", "Upgrade zum Ordenschampion");
		rkBoss.initKammer(true, true, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

                if(!siegeForce) {
                
                    seperator();

                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);
                    
                }

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());

                if(!siegeForce) {
                
                    rkTransport.setAktiv(!rkPod.isSelected());
                    rkPod.setAktiv(!rkTransport.isSelected());
                    
                }

		int selectedSquads = BuildaHQ.getCountFromInformationVector("SMHonourGuard");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("SMEnableHonourGuard");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Ehrengarde > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SMHonourGuard", -1);
		super.deleteYourself();
	}
	
}
