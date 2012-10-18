package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMProtektorgarde extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
        
        boolean siegeForce;

	public SMProtektorgarde() {
		name = "Protektorgarde\n";
		grundkosten = 0;
		überschriftSetzen = true;

                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
                
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Veteranen", 5, 10, 25);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMProtektorgarde.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMProtektorSergeant", "Upgrade zum Sergeant");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer();
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

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
        
		o1.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl());
                
                if(!siegeForce) {

                    rkTransport.setAktiv(!rkPod.isSelected());
                    rkPod.setAktiv(!rkTransport.isSelected());
                    
                }
	}

}
